package nikmax.shimmer

import androidx.compose.ui.graphics.Color

sealed interface ShimmerEffect {
    sealed interface OffsetShimmerEffect : ShimmerEffect {
        data class HorizontalWave(
            val backgroundColor: Color = Constants.DEFAULT_COLOR,
            val waveColor: Color = Constants.DEFAULT_COLOR
        ) : OffsetShimmerEffect
    }
    
    sealed interface ColorChangeShimmerEffect : ShimmerEffect {
        data class ColorPulsation(
            val firstColor: Color = Constants.DEFAULT_COLOR,
            val secondColor: Color = Constants.DEFAULT_COLOR
        ) : ColorChangeShimmerEffect
    }
}
