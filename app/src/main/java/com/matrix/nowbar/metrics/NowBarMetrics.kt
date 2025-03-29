package com.matrix.nowbar.metrics

import androidx.compose.ui.unit.Dp

/**
 * Data class representing NowBar metrics.
 * @param cornerRadius The corner radius of the now bar widget.
 * @param widgetHeight The height of the now bar widget.
 * @param translationClamp The translation clamp of the now bar widget.
 * @param shadowElevation The shadow elevation of the now bar widget.
 * @param fillMaxWidthOffset The fill max width offset of the now bar widget.
 * @param animationMultiplier The animation multiplier of the now bar widget.
 * @author Saurav Sajeev
 */
data class NowBarMetrics(
    var cornerRadius: Dp = Dimensions.BorderRadius,
    var widgetHeight: Dp = Dimensions.NowBarHeight,
    var translationClamp: Pair<Float, Float> = Dimensions.TranslationClamp,
    var shadowElevation: Dp = Dimensions.ShadowElevation,
    var fillMaxWidthOffset: Float = Dimensions.FillMaxWidthOffset,
    var animationMultiplier: Int = 1
)
