package com.dsckiet.movietails.repository.dataclass

import com.squareup.moshi.Json

data class DetailsListData(
    @Json(name = "{add JSON object keyword}")
    val imgUrl : String,
    @Json(name = "{add JSON object keyword}")
    val title : String,
    @Json(name = "{add JSON object keyword}")
    val rating : Double
)