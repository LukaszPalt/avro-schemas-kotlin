package com.lukaszpalt

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Year

class YearSerializer : KSerializer<Year> {

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("YearSerializer", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Year {
        return Year.parse(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: Year) {
        encoder.encodeString(value.toString())
    }
}
