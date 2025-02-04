package de.renao

import de.renao.models.RASettings
import de.renao.models.RAUserProfile
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.InputStream

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

var fetcher : RAFetcher = RAFetcher("","")

fun main() {
    val settings = loadSettings()
    fetcher = RAFetcher(settings.username, settings.webApiKey)

    runBlocking {
        val renao = loadUserData("renao")
        printUserData(renao)
    }
}

fun printUserData(userProfile: RAUserProfile) {
    println("User => ${userProfile.name} (ID: ${userProfile.id})")
    println("=== since ${userProfile.memberSince} ===")
    println("*** ${userProfile.totalPoints} total points ***")
    println("*** ${userProfile.totalTruePoints} total true points ***")
    println("*** ${userProfile.totalSoftcorePoints} total softcore points ***")
}

suspend fun loadUserData(username: String) : RAUserProfile {
    return fetcher.fetchUserProfile(username)
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