package com.ticketmaster.api.sdk

import kotlin.collections.Map
import kotlin.collections.List
import kotlin.reflect.KProperty
import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.rx.rx_object
import com.github.kittinunf.result.Result

/**
 * Created by dwebster on 6/25/16.
 */

class Event() {

}

class Filter {

}
class EventDescriptor(apiKey: String) {
    val map: MutableMap<String, String> = mutableMapOf("apikey" to apiKey)

    var keyword: String by map
    var attractionId: String by map
    var postalCode: String by map
    var latLong: String by map
    var venueId: String by map
    var radius: String by map
    var unit: String by map
    var page: String by map
    var size: String by map
    var sort: String by map

    fun search(): Unit {
        val (request, response, result) = "/discovery/v2/events.json".httpGet(map.toList()).responseString()
        result.fold(
                { data: String -> print("Great Success: " + data)},
                { error: FuelError -> print("Great Error: " + error)}
        )
    }
}


class Discovery(val apiKey : String){
    val events = EventDescriptor(apiKey)
}

class TM(basePath: String = "https://app.ticketmaster.com") {
    init {
        FuelManager.instance.basePath = basePath
    }
    fun discovery(apiKey: String) : Discovery { return Discovery(apiKey) }
}