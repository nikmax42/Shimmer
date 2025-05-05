package nikmax.shimmer

import androidx.compose.ui.graphics.Color

val DEFAULT_SHIMMER = Shimmer.OffsetShimmer.HorizontalWave()

sealed interface Shimmer {
    sealed interface OffsetShimmer : Shimmer {
        data class HorizontalWave(
            val backgroundColor: Color = Color.Black,
            val waveColor: Color = Color.White
        ) : OffsetShimmer
    }
}
