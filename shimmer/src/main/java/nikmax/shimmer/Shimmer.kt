package nikmax.shimmer

import androidx.compose.ui.graphics.Color

val DEFAULT_SHIMMER = Shimmer.ColorChangeShimmer.ColorPulsation()
val DEFAULT_COLOR = Color.Unspecified

sealed interface Shimmer {
    sealed interface OffsetShimmer : Shimmer {
        data class HorizontalWave(
            val backgroundColor: Color = DEFAULT_COLOR,
            val waveColor: Color = DEFAULT_COLOR
        ) : OffsetShimmer
    }
    
    sealed interface ColorChangeShimmer : Shimmer {
        data class ColorPulsation(
            val firstColor: Color = DEFAULT_COLOR,
            val secondColor: Color = DEFAULT_COLOR
        ) : ColorChangeShimmer
    }
}
