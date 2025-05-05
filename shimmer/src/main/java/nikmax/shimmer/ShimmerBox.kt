package nikmax.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shimmer: Shimmer = DEFAULT_SHIMMER
) {
    Box(modifier.shimmerBackground(shimmer))
}
