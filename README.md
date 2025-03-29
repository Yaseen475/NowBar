# **NowBar**
This project is a fan-made recreation of Samsung's Now Bar from One UI 7, built entirely with Jetpack Compose. It is not affiliated with or endorsed by Samsung in any way but serves as a tribute to their innovative UI design.

---

## **NowBarWidget**
The **NowBarWidget** is inspired by Samsung's Now Bar lock screen interactive widget. It's a customizable widget system, providing gesture-based interactions and dynamic scaling effects. Below is the detailed API documentation:

### **Parameters**
```kotlin
/**
 * NowBar Widget inspired from Samsung's Now Bar lockscreen interactive widget.
 * @param innerPadding The innerPadding for the widget.
 * @param widgets The list of widgets to be displayed. Accepts NowBarComponent type widgets. 
 *                You can make your own NowBarComponent widget from NowBarComponent class.
 * @param modifier The modifier for the widget.
 * @param metrics The custom metrics object for the widget.
 * @param dragDirection The drag direction which is to be supported by the widget. 
 *                      Accepts values from NowBarDragController enum.
 * @author Saurav Sajeev
 */
@Composable
fun NowBarWidget(
    innerPadding: PaddingValues,
    widgets: MutableList<NowBarComponent>,
    modifier: Modifier = Modifier,
    metrics: NowBarMetrics = NowBarMetrics(),
    dragDirection: NowBarDragController = NowBarDragController.DRAG_UP
)
```

---

## **NowBarComponent**
```kotlin
/**
 * The NowBarComponent class represents a widget in the NowBar widget system.
 * @param widget The widget to be displayed.
 * @param dismissible A flag indicating whether the widget can be dismissed using the gesture.
 */
data class NowBarComponent(
    val widget: @Composable () -> Unit,
    val dismissible: Boolean = true,
)
```

---

## **Customizable Widgets**
### MediaPlayerWidget
```kotlin
/**
 * Media player widget that supports playing music and providing sharing functionality.
 * @param music A list of music resources with their corresponding titles.
 * @param innerPadding The inner padding values for the widget.
 */
@Composable
fun MediaPlayerWidget(music: List<Pair<Int, String>>, innerPadding: PaddingValues)
```

### NotificationWidget
```kotlin
/**
 * Customizable notification widget that displays an icon, title, and content.
 * @param icon The resource ID of the icon to be displayed.
 * @param title The title of the notification.
 * @param content The content of the notification.
 * @param colorController The color controller for the notification.
 */
@Composable
fun NotificationWidget(
    icon: Int,
    title: String,
    content: String,
    colorController: NotificationColorController = NotificationColorController()
)
```

### RoutinesWidget
```kotlin
/**
 * Customizable routines widget that displays a title and content.
 * @param title The title of the widget.
 * @param content The content of the widget.
 */
@Composable
fun RoutinesWidget(
    title: String = "Bixby Routines",
    content: String
)
```

### SportsWidget
```kotlin
/**
 * Customizable sports widget that displays a title and content.
 * @param title The title of the widget.
 * @param content The content of the widget.
 */
@Composable
fun SportsWidget(title: String, content: String)
```

### TimerWidget
```kotlin
/**
 * Customizable timer widget that displays a title and content.
 * @param seconds The time in seconds.
 */
@Composable
fun TimerWidget(seconds: Int)
```

---

## **NowBar Metrics**
```kotlin
/**
 * Data class representing NowBar metrics.
 * @param cornerRadius The corner radius of the now bar widget.
 * @param widgetHeight The height of the now bar widget.
 * @param translationClamp The translation clamp of the now bar widget.
 * @param shadowElevation The shadow elevation of the now bar widget.
 * @param fillMaxWidthOffset The fill max width offset of the now bar widget.
 * @param animationMultiplier The animation multiplier of the now bar widget.
 */
data class NowBarMetrics(
    var cornerRadius: Dp = Dimensions.BorderRadius,
    var widgetHeight: Dp = Dimensions.NowBarHeight,
    var translationClamp: Pair<Float, Float> = Dimensions.TranslationClamp,
    var shadowElevation: Dp = Dimensions.ShadowElevation,
    var fillMaxWidthOffset: Float = Dimensions.FillMaxWidthOffset,
    var animationMultiplier: Int = 1
)
```

---

## **Notification Color Controller**
```kotlin
/**
 * Data class representing notification color controller.
 * @param backgroundColor The background color of the notification.
 * @param backgroundColorGradient The background gradient color of the notification.
 * @param iconColor The icon color of the notification.
 * @param titleColor The title color of the notification.
 * @param contentColor The content color of the notification.
 */
data class NotificationColorController(
    var backgroundColor: Color = Color(0xFF303164),
    var backgroundColorGradient: Brush? = null,
    var iconColor: Color = Color.White,
    var titleColor: Color = Color.White,
    var contentColor: Color = Color.White
)
```

---

### **Example Code:**
Below is a sample implementation to get started:

```kotlin
package com.matrix.nowbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.matrix.nowbar.widgets.*

class MainActivity : ComponentActivity() {

    val music = listOf(
        R.drawable.bliever to "Believer_Imagine Dragons",
        R.drawable.sit_next to "Sit Next To Me_Foster The People",
        R.drawable.renegade to "Renegade_Axwell /\ Ingrosso"
    )

    val widgets = mutableListOf(
        NowBarComponent({ MediaPlayerWidget(music, PaddingValues.Absolute(0.dp)) }, isRemovable = false),
        NowBarComponent({ TimerWidget(seconds = 65) }),
        NowBarComponent({ RoutinesWidget(content = "At work and 2 others running") }),
        NowBarComponent({
            SportsWidget(
                "ICC Champions Trophy 2025 (Final)\nIND vs NZ",
                "IND won by 4 wickets"
            )
        }),
        NowBarComponent({
            NotificationWidget(
                R.drawable.ic_linkedin,
                "LinkedIn",
                "You appeared in 54 searches last week.",
                colorController = NotificationColorController(
                    backgroundColorGradient = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0A66C2),
                            Color(0xFFB3D5FA)
                        )
                    )
                )
            )
        }),
        NowBarComponent({
            NotificationWidget(
                R.drawable.ic_flipkart,
                "Arriving today",
                "Your order Acer Predator Gaming Laptop is out for delivery.",
                colorController = NotificationColorController(
                    backgroundColorGradient = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFADC1E),
                            Color(0xFF0D69B3)
                        )
                    )
                )
            )
        })
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    NowBarWidget(innerPadding, widgets)
                }
            }
        }
    }
}
```

---