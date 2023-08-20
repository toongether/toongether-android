package kr.toongether.common.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.RuntimeException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend inline fun <T> networkHandler(
    crossinline networkCall: suspend () -> T
): T {
    return try {
        withContext(Dispatchers.IO) {
            networkCall.invoke()
        }
    } catch (e: HttpException) {
        val message = e.response()?.errorBody()?.string()?.split(":\"", "\"}")?.get(1)

        when (e.code()) {
            500, 501, 502, 503 -> {
                throw RuntimeException(InternalServerExceptionMessage)
            }
            else -> {
                throw RuntimeException(message)
            }
        }
    } catch (e: UnknownHostException) {
        throw RuntimeException(NetworkExceptionMessage)
    } catch (e: SocketTimeoutException) {
        throw RuntimeException(e.message)
    }
}

const val NetworkExceptionMessage = "네트워크 연결을 확인해주세요."
const val InternalServerExceptionMessage = "서버 연결에 실패했어요.."
