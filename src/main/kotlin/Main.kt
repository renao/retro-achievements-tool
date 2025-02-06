package de.renao

import de.renao.models.*
import de.renao.renderers.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.InputStream

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

var fetcher : RAFetcher = RAFetcher("", "")

fun main() {
    val settings = loadSettings()
    fetcher = RAFetcher(settings.username, settings.webApiKey)

    runBlocking {
        val renao = fetcher.fetchUserProfile("renao")
        UserProfileRenderer.renderProfile(renao)

        val userGameCompletion = fetcher.fetchUserGameProgress("renao", 15935)
        UserGameCompletionRenderer.renderGameCompletion(userGameCompletion, onlyMissing = false)

    }
}

fun loadSettings() : RASettings {
    val settingsText = loadFromResources("ra-settings.json")
    return Json.decodeFromString<RASettings>(settingsText)
}

fun loadFromResources(fileName: String): String {
    val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("/$fileName")
    return inputStream?.bufferedReader()?.use { it.readText() }
        ?: throw IllegalArgumentException("File not found: $fileName")
}