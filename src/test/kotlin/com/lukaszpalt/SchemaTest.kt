package com.lukaszpalt

import com.github.avrokotlin.avro4k.Avro
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class SchemaTest {

    @Test
    fun `Book schema is generated correctly`() {
        val expectedSchema = """
            {
              "type" : "record",
              "name" : "Book",
              "namespace" : "com.lukaszpalt",
              "fields" : [ {
                "name" : "title",
                "type" : "string"
              }, {
                "name" : "author",
                "type" : {
                  "type" : "record",
                  "name" : "Author",
                  "fields" : [ {
                    "name" : "firstName",
                    "type" : "string"
                  }, {
                    "name" : "lastName",
                    "type" : "string"
                  } ]
                }
              }, {
                "name" : "publicationYear",
                "type" : "string"
              }, {
                "name" : "numberOfPages",
                "type" : "int"
              }, {
                "name" : "price",
                "type" : {
                  "type" : "record",
                  "name" : "Price",
                  "fields" : [ {
                    "name" : "amount",
                    "type" : "string"
                  }, {
                    "name" : "currency",
                    "type" : {
                      "type" : "enum",
                      "name" : "CurrencyType",
                      "symbols" : [ "USD", "EUR", "NOK" ]
                    }
                  } ]
                }
              }, {
                "name" : "isbn",
                "type" : "string"
              } ]
            }
        """.trimIndent()

        val actualSchema = Avro
            .default
            .schema(Book.serializer())
            .toString(true)

        assertEquals(expectedSchema, actualSchema)
    }
}