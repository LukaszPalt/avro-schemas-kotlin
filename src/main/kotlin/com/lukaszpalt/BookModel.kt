package com.lukaszpalt

import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.time.Year

@Serializable
enum class CurrencyType {
    USD, EUR, NOK
}

@Serializable
data class Price(
    @Serializable(with = BigDecimalSerializer::class) var amount: BigDecimal,
    var currency: CurrencyType
)

@Serializable
data class Author(
    val firstName: String,
    val lastName: String
)

@Serializable
data class Book(
    val title: String,
    val author: Author,
    @Serializable(with = YearSerializer::class) val publicationYear: Year,
    val numberOfPages: Int,
    val price: Price,
    val isbn: String
)
