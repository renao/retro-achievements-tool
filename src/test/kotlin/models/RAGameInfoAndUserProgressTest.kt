package models

import de.renao.models.RAGameInfoAndUserProgress
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress

class RAGameInfoAndUserProgressTest {

    @Test
    fun `Initializes based on API response object`() {
        val response = createGetGameInfoAndUserProgressResponse()
        val model = RAGameInfoAndUserProgress(response)

        assertEquals(response.title, model.title)
        assertEquals(response.userCompletion, model.userCompletion)
        assertEquals(response.userCompletionHardcore, model.userCompletionHardcore)
        assertEquals(response.numAwardedToUser, model.numAwardedToUser)
        assertEquals(response.numAwardedToUserHardcore, model.numAwardedToUserHardcore)
        assertEquals(response.numAchievements, model.numAchievements)

        // assertEquals(response.achievements.toList(), model.achievements)
    }

    private fun createGetGameInfoAndUserProgressResponse(): GetGameInfoAndUserProgress.Response {
        return mockk<GetGameInfoAndUserProgress.Response>(relaxed = true)
    }
}