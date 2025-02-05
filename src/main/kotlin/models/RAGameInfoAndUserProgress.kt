package de.renao.models

import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress

class RAGameInfoAndUserProgress(response: GetGameInfoAndUserProgress.Response) {

    val title = response.title
    val achievements = response.achievements
        .map { ach -> RAUserProgressAchievement(ach.value) }
        .toList()
    val userCompletion = response.userCompletion
    val userCompletionHardcore = response.userCompletionHardcore
    val numAchievements = response.numAchievements
    val numAwardedToUser = response.numAwardedToUser
    val numAwardedToUserHardcore = response.numAwardedToUserHardcore
}