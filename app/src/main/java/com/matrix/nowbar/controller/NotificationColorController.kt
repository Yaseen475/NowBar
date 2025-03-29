package com.matrix.nowbar.controller

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Data class representing notification color controller.
 * @param backgroundColor The background color of the notification.
 * @param backgroundColorGradient The background gradient color of the notification.
 * @param iconColor The icon color of the notification.
 * @param titleColor The title color of the notification.
 * @param contentColor The content color of the notification.
 * @author Saurav Sajeev
 */
data class NotificationColorController(
    var backgroundColor: Color = Color(0xFF303164),
    var backgroundColorGradient: Brush? = null,
    var iconColor: Color = Color.White,
    var titleColor: Color = Color.White,
    var contentColor: Color = Color.White
)