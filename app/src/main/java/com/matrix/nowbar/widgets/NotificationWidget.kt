package com.matrix.nowbar.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matrix.nowbar.controller.NotificationColorController
import com.matrix.nowbar.metrics.Dimensions

/**
 * Customizable notification widget that displays an icon, title, and content.
 * @param icon The resource ID of the icon to be displayed.
 * @param title The title of the notification.
 * @param content The content of the notification.
 * @param colorController The color controller for the notification.
 * @author Saurav Sajeev
 */
@Composable
fun NotificationWidget(
    icon: Int,
    title: String,
    content: String,
    colorController: NotificationColorController = NotificationColorController()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = colorController.backgroundColorGradient ?: Brush.linearGradient(
                    0.5f to colorController.backgroundColor,
                    05f to colorController.backgroundColor
                )
            )
            .padding(end = 20.dp, top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(Dimensions.BorderRadius)),
    ) {

        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(PaddingValues.Absolute(30.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painterResource(icon),
                contentDescription = "Notification Icon",
                tint = colorController.iconColor,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    title,
                    color = colorController.titleColor,
                    fontSize = 13.sp,
                    lineHeight = 13.sp,
                    fontWeight = FontWeight.W700
                )

                Text(
                    content,
                    color = colorController.contentColor,
                    fontSize = 13.sp,
                    lineHeight = 13.sp,
                    fontWeight = FontWeight.W400,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}