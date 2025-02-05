package de.renao

import de.renao.models.RAGameInfoAndUserProgress
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
        val renao = fetcher.fetchUserProfile("renao")
        printUserData(renao)

        val userGameCompletion = fetcher.fetchUserGameProgress("renao", 15935)
        printUserGameCompletion(userGameCompletion, onlyMissing = false);

    }
}

fun printUserData(userProfile: RAUserProfile) {
    println("User => ${userProfile.name} (ID: ${userProfile.id})")
    println("=== since ${userProfile.memberSince} ===")
    println("*** ${userProfile.totalPoints} total points ***")
    println("*** ${userProfile.totalTruePoints} total true points ***")
    println("*** ${userProfile.totalSoftcorePoints} total softcore points ***")
}

fun printUserGameCompletion(gameCompletion: RAGameInfoAndUserProgress, onlyMissing: Boolean = false) {
    for (achievement in gameCompletion.achievements) {
        var achievementStatus = "⬜"

        if (!achievement.dateEarned.isNullOrEmpty()) {
            achievementStatus = "✔️"
        }

        if (!achievement.dateEarnedHardcore.isNullOrEmpty()) {
            achievementStatus = "✅"
        }

        if (achievementStatus != "⬜" && onlyMissing) continue

        println("$achievementStatus ${achievement.title}")
        println("${achievement.description}")
        println()

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