package nikmax.shimmer

import androidx.compose.ui.Modifier
import nikmax.shimmer.Shimmers.horizontalWave


/**
 * Animated shimmer background.
 *
 * @param shimmer
 * */
fun Modifier.shimmerBackground(shimmer: Shimmer = DEFAULT_SHIMMER): Modifier {
    return when (shimmer) {
        is Shimmer.OffsetShimmer.HorizontalWave -> this.horizontalWave(
            backgroundColor = shimmer.backgroundColor,
            waveColor = shimmer.waveColor
        )
    }
}
