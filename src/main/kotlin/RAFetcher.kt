package de.renao

import com.haroldadmin.cnradapter.NetworkResponse
import de.renao.models.RAGameInfoAndUserProgress
import de.renao.models.RAUserProfile
import org.retroachivements.api.RetroClient
import org.retroachivements.api.RetroInterface
import org.retroachivements.api.data.RetroCredentials
import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress

class RAFetcher(username: String, apiKey: String) {

    private val api : RetroInterface

    init {
        val credentials = RetroCredentials(username, apiKey)
        api = RetroClient(credentials).api
    }

    suspend fun fetchUserProfile(profileUsername: String) : RAUserProfile {
        val response = api.getUserProfile(profileUsername)

        when (response) {
            is NetworkResponse.Success
                -> return RAUserProfile(response.body)
            else
                -> throw Exception("Error fetching user profile for '$profileUsername'")
        }

    }

    suspend fun fetchUserGameProgress(username: String, gameId: Long) : RAGameInfoAndUserProgress {
        val response = api.getGameInfoAndUserProgress(username, gameId)

        when (response) {
            is NetworkResponse.Success<*, *>
                -> return RAGameInfoAndUserProgress(response.body as GetGameInfoAndUserProgress.Response)
            else
                -> throw Exception("Error fetching user $username progress for Game-ID: '$gameId'")
        }
    }
}