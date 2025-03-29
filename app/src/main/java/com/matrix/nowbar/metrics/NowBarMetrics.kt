package com.matrix.nowbar.metrics

import androidx.compose.ui.unit.Dp

data class NowBarMetrics(
    var cornerRadius: Dp = Dimensions.BorderRadius,
    var widgetHeight: Dp = Dimensions.NowBarHeight,
    var translationClamp: Pair<Float, Float> = Dimensions.TranslationClamp,
    var shadowElevation: Dp = Dimensions.ShadowElevation,
    var fillMaxWidthOffset: Float = Dimensions.FillMaxWidthOffset,
    var animationMultiplier: Int = 1
)
