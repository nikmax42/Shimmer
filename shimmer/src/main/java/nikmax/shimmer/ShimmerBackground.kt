package nikmax.shimmer

import androidx.compose.ui.Modifier

/**
 * Animated shimmer background.
 *
 * @param shimmerEffect
 * */
fun Modifier.shimmerBackground(shimmerEffect: ShimmerEffect = DEFAULT_SHIMMER_EFFECT): Modifier {
    return when (shimmerEffect) {
        is ShimmerEffect.OffsetShimmerEffect.HorizontalWave -> this.horizontalWave(
            backgroundColor = shimmerEffect.backgroundColor,
            waveColor = shimmerEffect.waveColor
        )
        is ShimmerEffect.ColorChangeShimmerEffect.ColorPulsation -> this.colorPulsation(
            firstColor = shimmerEffect.firstColor,
            secondColor = shimmerEffect.secondColor
        )
    }
}
