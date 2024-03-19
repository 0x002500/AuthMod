package com.zerox.authmod.logic

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString


@Serializable
data class GithubLoginEndpoint(val client_id: String, val scope: String)

class LoginCommandLogic {
    companion object {
        @JvmStatic
        fun verifyPassword(sourceUuid: String, password: String): Boolean {

            return false
        }
    }
}