package de.renao.models

import kotlinx.serialization.Serializable

@Serializable
data class RASettings(val username: String, val webApiKey: String)