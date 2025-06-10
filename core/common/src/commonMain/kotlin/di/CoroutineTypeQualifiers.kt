package di

import org.koin.core.qualifier.named


object CoroutineTypeQualifiers {
    val ioDispatcherQualifier = named("IoDispatcher")
    val defaultDispatcherQualifier = named("defaultDispatcher")
}
