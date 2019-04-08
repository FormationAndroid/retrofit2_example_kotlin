package com.monentreprise.stackquestions.api.models

import com.google.gson.annotations.SerializedName

data class Questions(
    @SerializedName("has_more")
    val hasMore: Boolean?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("quota_max")
    val quotaMax: Int?,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int?
)