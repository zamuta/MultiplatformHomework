/**
 * The News API
 *
 * ...
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param found 
 * @param returned 
 * @param limit 
 * @param page 
 */
@Serializable
data class Meta (

    @SerialName(value = "found") @Required val found: kotlin.Int,

    @SerialName(value = "returned") @Required val returned: kotlin.Int,

    @SerialName(value = "limit") @Required val limit: kotlin.Int,

    @SerialName(value = "page") @Required val page: kotlin.Int

)

