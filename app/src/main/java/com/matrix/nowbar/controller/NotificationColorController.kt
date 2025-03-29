package com.matrix.nowbar.controller

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


data class NotificationColorController(
    var backgroundColor: Color = Color(0xFF303164),
    var backgroundColorGradient: Brush? = null,
    var iconColor: Color = Color.White,
    var titleColor: Color = Color.White,
    var contentColor: Color = Color.White
)