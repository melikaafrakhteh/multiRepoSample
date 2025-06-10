package di

import dispatcher.ioDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutineModule = module {
    single<CoroutineDispatcher>(CoroutineTypeQualifiers.ioDispatcherQualifier) { ioDispatcher }
    single<CoroutineDispatcher>(CoroutineTypeQualifiers.defaultDispatcherQualifier) { Dispatchers.Default }
}
