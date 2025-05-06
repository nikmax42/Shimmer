package nikmax.shimmer

import androidx.compose.ui.graphics.Color

val DEFAULT_SHIMMER = Shimmer.ColorChangeShimmer.ColorPulsation()

private val DEFAULT_FIRST_COLOR = Color.DarkGray.copy(alpha = 0.5f)
private val DEFAULT_SECOND_COLOR = Color.LightGray.copy(alpha = 0.5f)

sealed interface Shimmer {
    sealed interface OffsetShimmer : Shimmer {
        data class HorizontalWave(
            val backgroundColor: Color = DEFAULT_FIRST_COLOR,
            val waveColor: Color = DEFAULT_SECOND_COLOR
        ) : OffsetShimmer
    }
    
    sealed interface ColorChangeShimmer : Shimmer {
        data class ColorPulsation(
            val firstColor: Color = DEFAULT_FIRST_COLOR,
            val secondColor: Color = DEFAULT_SECOND_COLOR
        ) : ColorChangeShimmer
    }
}
