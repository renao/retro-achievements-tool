package de.renao.presenters

import de.renao.models.AchievementState

object AchievementPresenter {

    fun RenderState(state: AchievementState) : String {
        return when (state) {
            AchievementState.Beaten -> "✔️"
            AchievementState.BeatenInHardcore -> "✅"
            AchievementState.Unbeaten -> "⬜"
        }
    }
}