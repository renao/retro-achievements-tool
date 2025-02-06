package de.renao.models

import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response.Achievement as RAAchievement

class RAUserProgressAchievement(achievement: RAAchievement) {

    val id = achievement.id
    val title = achievement.title
    val description = achievement.description
    val badgeName = achievement.badgeName
    val type = achievement.type
    val dateEarned = achievement.dateEarned
    val dateEarnedHardcore = achievement.dateEarnedHardcore
    val state = resolveState(achievement)

    private fun resolveState(achievement: RAAchievement) : AchievementState {
        if (!achievement.dateEarnedHardcore.isNullOrEmpty()) {
            return AchievementState.BeatenInHardcore
        }

        if (!achievement.dateEarned.isNullOrEmpty()) {
            return AchievementState.Beaten
        }

        return AchievementState.Unbeaten
    }


}
