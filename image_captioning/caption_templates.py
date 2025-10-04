
"""
Road Condition Caption Templates
도로 상태별 캡션 템플릿 관리 모듈
"""

import random

# 카테고리별 영어 캡션 템플릿
ROAD_CAPTIONS = {
    "cracked": [
        "the road surface is cracked",
        "there are cracks on the pavement",
        "the asphalt has fractures",
        "pavement shows cracking damage",
        "road has visible cracks",
        "surface has crack patterns",
        "asphalt is fractured",
        "road shows crack deterioration"
    ],
    
    "pothole": [
        "the road has pothole",
        "there is depression in the pavement",
        "the road surface is damaged with pothole",
        "pavement has deep pothole",
        "road shows pothole damage",
        "surface has pothole defect",
        "asphalt has pothole formation",
        "road has significant pothole"
    ],
    
    "good": [
        "the road is in good condition",
        "the pavement is smooth",
        "the road surface is intact",
        "asphalt is well maintained",
        "road shows no damage",
        "surface is in excellent condition",
        "pavement is undamaged",
        "road has smooth surface"
    ]
}

# 카테고리 매핑 (다양한 이름 처리)
CATEGORY_MAPPING = {
    "cracked": "cracked",
    "crack": "cracked",
    "cracks": "cracked",
    
    "pothole": "pothole",
    "potholes": "pothole",
    "파임": "pothole",
    
    "good": "good",
    "normal": "good",
    "양호": "good",
    "양호함": "good"
}


def get_caption(category, random_choice=True):
    """
    카테고리에 해당하는 캡션 반환
    
    Args:
        category (str): 도로 상태 카테고리
        random_choice (bool): True면 랜덤 선택, False면 첫 번째 캡션 반환
    
    Returns:
        str: 캡션 문장
    """
    # 카테고리 정규화
    normalized_category = CATEGORY_MAPPING.get(category.lower(), "good")
    
    captions = ROAD_CAPTIONS.get(normalized_category, ROAD_CAPTIONS["good"])
    
    if random_choice:
        return random.choice(captions)
    else:
        return captions[0]


def get_all_captions(category):
    """
    카테고리의 모든 캡션 반환
    
    Args:
        category (str): 도로 상태 카테고리
    
    Returns:
        list: 캡션 리스트
    """
    normalized_category = CATEGORY_MAPPING.get(category.lower(), "good")
    return ROAD_CAPTIONS.get(normalized_category, ROAD_CAPTIONS["good"])


def add_sos_eos(caption):
    """
    캡션에 시작/종료 토큰 추가
    
    Args:
        caption (str): 원본 캡션
    
    Returns:
        str: <sos>와 <eos>가 추가된 캡션
    """
    return f'<sos> {caption} <eos>'


def preprocess_caption(caption):
    """
    영어 캡션 전처리 (관사 제거)
    
    Args:
        caption (str): 원본 캡션
    
    Returns:
        str: 전처리된 캡션
    """
    # 관사 제거
    caption = caption.replace(" a ", " ")
    caption = caption.replace("A ", "")
    caption = caption.replace("An ", "")
    caption = caption.replace(" an ", " ")
    caption = caption.replace(" the ", " ")
    caption = caption.replace("The ", "")
    
    # 연속 공백 제거
    caption = " ".join(caption.split())
    
    return caption


def generate_caption_with_tokens(category, preprocess=True, random_choice=True):
    """
    전처리 + 토큰 추가된 완성 캡션 생성
    
    Args:
        category (str): 도로 상태 카테고리
        preprocess (bool): 전처리 수행 여부
        random_choice (bool): 랜덤 선택 여부
    
    Returns:
        str: 완성된 캡션
    """
    caption = get_caption(category, random_choice)
    
    if preprocess:
        caption = preprocess_caption(caption)
    
    return add_sos_eos(caption)


# 카테고리 목록
CATEGORIES = list(ROAD_CAPTIONS.keys())


if __name__ == "__main__":
    # 테스트 코드
    print("=== Caption Templates Test ===\n")
    
    for category in CATEGORIES:
        print(f"Category: {category}")
        print(f"  Random caption: {get_caption(category)}")
        print(f"  With tokens: {generate_caption_with_tokens(category)}")
        print(f"  All captions ({len(get_all_captions(category))}): {get_all_captions(category)[0]}...")
        print()