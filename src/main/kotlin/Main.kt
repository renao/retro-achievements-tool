@file:OptIn(DelicateCoroutinesApi::class)

package de.renao

import de.renao.renderers.*
import kotlinx.coroutines.*

val settings = ResourcesSettingsLoader.loadSettings()
val fetcher : RAFetcher = RAFetcher(settings.username, settings.webApiKey)

fun main() {

    val userInfo = GlobalScope.async { fetcher.fetchUserProfile("renao") }
    val userGameCompletion = GlobalScope.async { fetcher.fetchUserGameProgress("renao", 15935) }

    runBlocking {
        UserProfileRenderer.renderProfile(userInfo.await())
        UserGameCompletionRenderer.renderGameCompletion(userGameCompletion.await(), onlyMissing = false)
    }
}