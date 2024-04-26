package kr.toongether.data.model

import kr.toongether.model.UserInfo
import kr.toongether.network.model.UserInfoResponse

internal fun UserInfoResponse.asModel() = UserInfo(
    id = id,
    userId = userId,
    email = email,
    name = name,
    profileImage = profileImage,
)
