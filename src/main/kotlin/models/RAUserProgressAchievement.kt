package de.renao.models

import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress

class RAUserProgressAchievement(RAachievement: GetGameInfoAndUserProgress.Response.Achievement) {

    val id = RAachievement.id
    val title = RAachievement.title
    val description = RAachievement.description
    val badgeName = RAachievement.badgeName
    val type = RAachievement.type
    val dateEarned = RAachievement.dateEarned
    val dateEarnedHardcore = RAachievement.dateEarnedHardcore

}
