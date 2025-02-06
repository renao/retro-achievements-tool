package de.renao.renderers

import de.renao.models.AchievementState
import de.renao.models.RAGameInfoAndUserProgress
import de.renao.models.RAUserProgressAchievement

object UserGameCompletionRenderer {

    fun renderGameCompletion(gameCompletion: RAGameInfoAndUserProgress, onlyMissing: Boolean = false) {

        for (achievement in gameCompletion.achievements) {
            if (achievement.state != AchievementState.Unbeaten && onlyMissing) continue

            println("${renderAchievementState(achievement)} ${achievement.title}")
            println(achievement.description)
            println()
        }
    }

    private fun renderAchievementState(achievement: RAUserProgressAchievement) : String {
        return when (achievement.state) {
            AchievementState.Beaten -> "✔️"
            AchievementState.BeatenInHardcore -> "✅"
            AchievementState.Unbeaten -> "⬜"
        }
    }
}