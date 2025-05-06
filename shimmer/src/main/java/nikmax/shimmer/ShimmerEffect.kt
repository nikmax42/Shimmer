package nikmax.shimmer

import androidx.compose.ui.graphics.Color

val DEFAULT_SHIMMER_EFFECT = ShimmerEffect.ColorChangeShimmerEffect.ColorPulsation()
val DEFAULT_COLOR = Color.Unspecified

sealed interface ShimmerEffect {
    sealed interface OffsetShimmerEffect : ShimmerEffect {
        data class HorizontalWave(
            val backgroundColor: Color = DEFAULT_COLOR,
            val waveColor: Color = DEFAULT_COLOR
        ) : OffsetShimmerEffect
    }
    
    sealed interface ColorChangeShimmerEffect : ShimmerEffect {
        data class ColorPulsation(
            val firstColor: Color = DEFAULT_COLOR,
            val secondColor: Color = DEFAULT_COLOR
        ) : ColorChangeShimmerEffect
    }
}
