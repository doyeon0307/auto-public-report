import os
import json
import shutil
from datetime import datetime
from PIL import Image

# 카테고리 매핑 (한글 -> 영어 설명)
CATEGORY_MAPPING = {
    '깨짐': 'cracked',
    '양호함': 'good',
    '파임': 'potholed'
}

# COCO 캡션 템플릿
CAPTION_TEMPLATES = {
    '깨짐': [
        'The road surface is cracked',
        'This pavement shows cracks',
        'Road with visible cracks'
    ],
    '양호함': [
        'The road surface is in good condition',
        'This pavement is well-maintained',
        'Road with smooth surface'
    ],
    '파임': [
        'The road surface is potholed',
        'This pavement has potholes',
        'Road with damaged surface showing potholes'
    ]
}

def create_coco_dataset(input_dir, output_dir):
    """
    COCO 형식의 이미지 캡셔닝 데이터셋 생성 및 파일명 정리
    
    Args:
        input_dir: 원본 데이터 디렉토리 (예: /raw-data)
        output_dir: 출력 디렉토리 (예: /coco)
    """
    
    # 출력 디렉토리 생성
    images_dir = os.path.join(output_dir, 'images')
    os.makedirs(images_dir, exist_ok=True)
    
    # COCO 형식 초기화
    coco_format = {
        "info": {
            "description": "Road Condition Image Captioning Dataset",
            "version": "1.0",
            "year": datetime.now().year,
            "date_created": datetime.now().strftime("%Y-%m-%d")
        },
        "licenses": [],
        "images": [],
        "annotations": []
    }
    
    image_id = 1
    annotation_id = 1
    
    # 각 카테고리별 이미지 카운터
    category_counters = {category: 1 for category in CATEGORY_MAPPING.keys()}
    
    # 지원하는 이미지 확장자
    valid_extensions = {'.jpg', '.jpeg', '.png', '.bmp', '.gif'}
    
    print("=" * 50)
    print("COCO 데이터셋 생성 시작")
    print("=" * 50)
    
    # 각 카테고리 폴더 순회
    for category_korean, category_english in CATEGORY_MAPPING.items():
        category_path = os.path.join(input_dir, category_korean)
        
        if not os.path.exists(category_path):
            print(f"⚠️  Warning: '{category_korean}' 폴더를 찾을 수 없습니다.")
            continue
        
        print(f"\n📁 처리 중: {category_korean} → {category_english}")
        
        # 폴더 내 이미지 파일 순회
        for filename in sorted(os.listdir(category_path)):
            file_ext = os.path.splitext(filename)[1].lower()
            
            if file_ext not in valid_extensions:
                continue
            
            original_path = os.path.join(category_path, filename)
            
            try:
                # 이미지 정보 가져오기
                with Image.open(original_path) as img:
                    width, height = img.size
                
                # 새 파일명 생성 (예: cracked_0001.jpg)
                counter = category_counters[category_korean]
                new_filename = f"{category_english}_{counter:04d}{file_ext}"
                new_path = os.path.join(images_dir, new_filename)
                
                # 이미지 복사
                shutil.copy2(original_path, new_path)
                
                # 이미지 정보 추가
                image_info = {
                    "id": image_id,
                    "file_name": new_filename,
                    "width": width,
                    "height": height,
                    "date_captured": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
                    "category": category_english
                }
                coco_format["images"].append(image_info)
                
                # 각 템플릿에 대해 annotation 생성
                for caption_template in CAPTION_TEMPLATES[category_korean]:
                    annotation = {
                        "id": annotation_id,
                        "image_id": image_id,
                        "caption": caption_template
                    }
                    coco_format["annotations"].append(annotation)
                    annotation_id += 1
                
                image_id += 1
                category_counters[category_korean] += 1
                
            except Exception as e:
                print(f"❌ Error processing {filename}: {e}")
                continue
        
        print(f"✅ {category_english}: {category_counters[category_korean] - 1}개 이미지 처리 완료")
    
    # JSON 파일로 저장
    annotations_path = os.path.join(output_dir, 'annotations.json')
    with open(annotations_path, 'w', encoding='utf-8') as f:
        json.dump(coco_format, f, indent=2, ensure_ascii=False)
    
    print("\n" + "=" * 50)
    print("✨ 완료!")
    print("=" * 50)
    print(f"📊 총 {len(coco_format['images'])}개의 이미지 처리")
    print(f"💬 총 {len(coco_format['annotations'])}개의 캡션 생성")
    print(f"📂 이미지 저장 위치: {images_dir}")
    print(f"📄 Annotation 저장 위치: {annotations_path}")
    
    # 통계 출력
    print("\n=== 카테고리별 통계 ===")
    for category_korean, category_english in CATEGORY_MAPPING.items():
        count = category_counters[category_korean] - 1
        print(f"{category_english} ({category_korean}): {count}개 이미지")
    
    return coco_format

if __name__ == "__main__":
    # 디렉토리 설정
    input_directory = "./raw-data"
    output_directory = "./coco"
    
    # COCO 데이터셋 생성
    create_coco_dataset(input_directory, output_directory)
    
    print("\n✅ 데이터셋 생성이 완료되었습니다!")