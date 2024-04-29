package kr.toongether.network.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.serialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.serializer

@Serializable(with = HomeViewResponseSerializer::class)
data class HomeViewResponse(
    @SerialName("type") val type: String,
    @SerialName("children") val children: Any,
)

object HomeViewResponseSerializer : KSerializer<HomeViewResponse> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("HomeViewResponse") {
        element("type", serialDescriptor<String>())
        element("children", buildClassSerialDescriptor("Any"))
    }

    private val typeSerializers: Map<String, KSerializer<Any>> =
        mapOf(
            "SERIES_BANNER" to serializer<List<SeriesResponse>>(),
            "SERIES_CONTAINER" to serializer<List<SeriesResponse>>(),
            "SHORTS_CONTAINER" to serializer<List<ShortsResponse>>()
        ).mapValues { (_, v) -> v as KSerializer<Any> }

    private fun getChildrenSerializer(type: String): KSerializer<Any> = typeSerializers[type]
        ?: throw SerializationException("Serializer for class $type is not registered in HomeViewResponseSerializer")


    @ExperimentalSerializationApi
    override fun deserialize(decoder: Decoder): HomeViewResponse = decoder.decodeStructure(descriptor) {
        if (decodeSequentially()) {
            val type = decodeStringElement(descriptor, 0)
            val children = decodeSerializableElement(descriptor, 1, getChildrenSerializer(type))
            HomeViewResponse(type, children)
        } else {
            require(decodeElementIndex(descriptor) == 0) { "type field should precede children field" }
            val type = decodeStringElement(descriptor, 0)
            val children = when (val index = decodeElementIndex(descriptor)) {
                1 -> decodeSerializableElement(descriptor, 1, getChildrenSerializer(type))
                CompositeDecoder.DECODE_DONE -> throw SerializationException("children field is missing")
                else -> error("Unexpected index: $index")
            }
            HomeViewResponse(type, children)
        }
    }

    override fun serialize(encoder: Encoder, value: HomeViewResponse) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type)
            encodeSerializableElement(descriptor, 1, getChildrenSerializer(value.type), value.children)
        }
    }
}