package kr.toongether.data.model

import kr.toongether.model.PublishStatus

internal fun String.asPublishStatus() = when (this) {
    PublishStatus.ON_GOING.name -> PublishStatus.ON_GOING
    PublishStatus.ON_HIATUS.name -> PublishStatus.ON_HIATUS
    PublishStatus.COMPLETED.name -> PublishStatus.COMPLETED
    else -> PublishStatus.ON_GOING
}
