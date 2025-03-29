package com.matrix.nowbar.widgets

import androidx.compose.runtime.Composable

/**
 * The NowBarComponent class represents a widget in the NowBar widget system.
 * @param widget The widget to be displayed.
 * @param dismissible A flag indicating whether the widget can be dismissed using the gesture.
 */
data class NowBarComponent(
    val widget: @Composable () -> Unit,
    val dismissible: Boolean = true,
)
