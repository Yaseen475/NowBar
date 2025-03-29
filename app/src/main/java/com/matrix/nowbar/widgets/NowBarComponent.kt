package com.matrix.nowbar.widgets

import androidx.compose.runtime.Composable

data class NowBarComponent(
    val widget: @Composable () -> Unit,
    val isRemovable: Boolean = true,
)
