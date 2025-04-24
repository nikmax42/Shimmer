package nikmax.shimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp


/**
 * Animated shimmer background.
 *
 * @param backgroundColor main background color.
 * @param activeColor animated "wave" color.
 * @param animationDuration wave speed (animation duration in milliseconds).
 * @param animationDelay delay before new wave start
 * */
fun Modifier.shimmerBackground(
    backgroundColor: Color,
    activeColor: Color,
    animationDuration: Int = 1000,
    animationDelay: Int = 1500
): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing,
                delayMillis = animationDelay
            )
        )
    )
    
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                backgroundColor,
                activeColor,
                backgroundColor,
            ),
            start = Offset(x = startOffsetX, y = 0f),
            end = Offset(x = startOffsetX + size.width.toFloat(), y = size.height.toFloat() / 5f)
        )
    ).onGloballyPositioned {
        size = it.size
    }
}

@Preview
@Composable
private fun ShimmerPreview() {
    Surface {
        Box(
            Modifier
                .size(64.dp)
                .shimmerBackground(
                    backgroundColor = Color.Black/* .copy(alpha = 0.5F) */,
                    activeColor = Color.DarkGray
                )
        )
    }
}
