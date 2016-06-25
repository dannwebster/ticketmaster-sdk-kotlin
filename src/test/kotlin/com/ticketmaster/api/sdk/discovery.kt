package com.ticketmaster.api.sdk

import kotlin.test.*
import org.junit.Test as test


class DiscoveryTest {
    val tm = TM()

    @test fun discoveryShouldExposeTheApiKey() {
        val discovery = tm.discovery("api-key")
        assertEquals("api-key", discovery.apiKey)
    }

    @test fun eventsShouldAllowAddingAKeyword() {
        val discovery = tm.discovery("api-key")
        discovery.events.keyword = "keyword"
        assertEquals("keyword", discovery.events.keyword)
    }

    @test fun eventsShouldFindEvents() {
        val discovery = tm.discovery("ZSD477Dj5k8ySDUAWMviEo0mJv88kHXf")
        discovery.events.keyword = "beyonce"
        discovery.events
                .search()
                .each(print)
    }
}