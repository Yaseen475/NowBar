package com.matrix.nowbar.extensions

internal fun Float.clamp(min: Float, max: Float) = if (this < min) min else if (this > max) max else this

internal fun Float.clamp(range: Pair<Float, Float>) = clamp(range.first, range.second)

internal fun Float.mapRange(
    fromMin: Float,
    fromMax: Float,
    toMin: Float,
    toMax: Float,
) = (((this - fromMin) / (fromMax - fromMin)) * (toMax - toMin) + toMin).clamp(toMin, toMax)
