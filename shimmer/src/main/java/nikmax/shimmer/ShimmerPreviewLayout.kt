package nikmax.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun ShimmerPreviewLayout(
    shimmedComponent: @Composable () -> Unit,
) {
    MaterialTheme {
        Surface {
            Box(Modifier.padding(48.dp)) {
                shimmedComponent()
            }
        }
    }
}
