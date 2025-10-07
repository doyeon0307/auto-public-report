package com.dokarun.autoreportapp.ui.submit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.ui.component.AddressDisplayField
import com.dokarun.autoreportapp.ui.component.AddressInputForm
import com.dokarun.autoreportapp.ui.component.AppBar
import com.dokarun.autoreportapp.ui.component.AppLargeButton
import com.dokarun.autoreportapp.ui.component.ImagePickerButton
import com.dokarun.autoreportapp.ui.component.InputSection
import com.dokarun.autoreportapp.ui.component.UnderLineInputField
import com.dokarun.autoreportapp.ui.theme.AppTheme


@Composable
internal fun SubmitScreen(
    appState: AppState,
    viewModel: SubmitViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    val imageWidth = 160.dp
    val imageHeight = 190.dp

    LaunchedEffect(appState.navController.currentBackStackEntry) {
        appState.navController.currentBackStackEntry
            ?.savedStateHandle
            ?.get<Pair<String, String>>("address")?.let { (road, _) ->
                appState.navController.currentBackStackEntry?.savedStateHandle?.remove<Pair<String, String>>(
                    "address"
                )
                viewModel.onAddressChanged(road)
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            AppBar {}
            InputSection(
                title = "불편사항을 알려주세요",
                description = "개선이 필요한 곳을 사진으로 찍어 등록해주세요",
            ) {
                Row {
                    ImagePickerButton(
                        modifier = Modifier
                            .width(imageWidth)
                            .height(imageHeight)
                            .padding(start = 16.dp, end = 10.dp),
                        onImagesSelected = { uriList ->
                            viewModel.onImagesSelected(uriList)
                        },
                    )
                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(uiState.images) { uri ->
                            AsyncImage(
                                modifier = Modifier
                                    .width(imageWidth)
                                    .height(imageHeight)
                                    .padding(end = 10.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                model = uri,
                                contentDescription = null,
                            )
                        }
                        item {
                            Spacer(Modifier.width(6.dp))
                        }
                    }
                }
            }
            InputSection(
                title = "위치를 알려주세요",
                description = "정확한 위치를 알려주시면 빠르게 도와드릴 수 있어요",
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AddressInputForm(
                        title = "주소",
                        message = if (uiState.address.isNotEmpty()) "이 주소가 아닌가요?" else null,
                        onMessageClick = {
                            appState.navController.navigate("zipWebView")
                        }
                    ) {
                        AddressDisplayField(
                            value = uiState.address,
                            placeholder = "주소를 입력해주세요",
                            onClick = {
                                appState.navController.navigate("zipWebView")
                            }
                        )
                    }
                    AddressInputForm(
                        title = "상세위치",
                    ) {
                        UnderLineInputField(
                            value = uiState.detailAddress,
                            onValueChange = { newText -> viewModel.onDetailAddressChanged(newText) },
                            placeholder = "자세한 위치를 입력해주세요",
                        )
                    }
                }
            }
            InputSection(
                title = "(선택) 추가로 작성하실 내용이 있나요?",
                description = "더 자세한 상황 전달을 원하신다면 여기에 작성해주세요",
                isRequired = false
            ) {
                UnderLineInputField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    value = uiState.description,
                    onValueChange = { newText -> viewModel.onDescriptionChanged(newText) },
                    placeholder = "여기에 입력해주세요",
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(AppTheme.colors.background)
                .align(Alignment.BottomCenter)
        ) {
            AppLargeButton(
                isEnabled = uiState.canSubmit,
                text = "접수하기",
                onClick = { viewModel.onSubmit() }
            )
        }
    }
}