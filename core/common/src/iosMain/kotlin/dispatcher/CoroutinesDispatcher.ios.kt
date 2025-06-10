package dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.DISPATCH_QUEUE_PRIORITY_DEFAULT
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.ThreadLocal

actual val ioDispatcher: CoroutineDispatcher = IosDefaultDispatcher


@ThreadLocal
private object IosDefaultDispatcher : CoroutineDispatcher() {

    @ExperimentalUnsignedTypes
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(
            dispatch_get_global_queue(
                DISPATCH_QUEUE_PRIORITY_DEFAULT.toLong(),
                0.toULong()
            )
        ) {
            try {
                block.run()
            } catch (err: Throwable) {
                throw err
            }
        }
    }
}
