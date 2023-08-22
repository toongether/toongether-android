package kr.toongether.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val toongetherDispatcher: ToongetherDispatcher)

enum class ToongetherDispatcher {
    Default,
    IO,
    Main,
}
