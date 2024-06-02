package kr.toongether.common.network.exception

// 400
class BadRequestException(
    override val message: String?,
) : RuntimeException()

// 401
class UnauthorizedException(
    override val message: String?,
) : RuntimeException()

// 403
class ForbiddenException(
    override val message: String?,
) : RuntimeException()

// 404
class NotFoundException(
    override val message: String?,
) : RuntimeException()

// 409
class ConflictException(
    override val message: String?,
) : RuntimeException()

// 429
class TooManyRequestsException(
    override val message: String?,
) : RuntimeException()

// 500
class InternalServerException(
    override val message: String?,
) : RuntimeException()
