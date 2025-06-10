package navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import androidx.lifecycle.flowWithLifecycle

@Composable
fun <T> CollectLatestOnStart(
    flow: Flow<T>,
    action: suspend (T) -> Unit
) {
    val lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle

    val lifecycleAwareFlow = remember(flow, lifecycle) {
        flow.flowWithLifecycle(
            lifecycle = lifecycle,
            minActiveState = Lifecycle.State.STARTED
        )
    }

    LaunchedEffect(Unit) {
        lifecycleAwareFlow.collectLatest(action)
    }
}