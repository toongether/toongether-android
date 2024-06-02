package kr.toongether.network.util

import kr.toongether.common.network.exception.BadRequestException
import kr.toongether.common.network.exception.ConflictException
import kr.toongether.common.network.exception.ForbiddenException
import kr.toongether.common.network.exception.InternalServerException
import kr.toongether.common.network.exception.NotFoundException
import kr.toongether.common.network.exception.TooManyRequestsException
import kr.toongether.common.network.exception.UnauthorizedException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend inline fun <T> networkHandler(
    crossinline networkCall: suspend () -> T
): T {
    return try {
        networkCall.invoke()
    } catch (e: HttpException) {
        val message = e.response()?.errorBody()?.string()?.split(":\"", "\"}")?.get(1)

        when (e.code()) {
            400 -> throw BadRequestException(message)
            401 -> throw UnauthorizedException(message)
            403 -> throw ForbiddenException(message)
            404 -> throw NotFoundException(message)
            409 -> throw ConflictException(message)
            429 -> throw TooManyRequestsException(message)
            500 -> throw InternalServerException(message)
            else -> throw RuntimeException(message)
        }
    } catch (e: UnknownHostException) {
        throw RuntimeException(NetworkExceptionMessage)
    } catch (e: SocketTimeoutException) {
        throw RuntimeException(e.message)
    }
}

const val NetworkExceptionMessage = "네트워크 연결을 확인해주세요."
