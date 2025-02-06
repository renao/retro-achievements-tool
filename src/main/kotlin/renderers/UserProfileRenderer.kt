package de.renao.renderers

import de.renao.models.RAUserProfile

object UserProfileRenderer {

    fun renderProfile(userProfile: RAUserProfile) {
        println("User => ${userProfile.name} (ID: ${userProfile.id})")
        println("=== since ${userProfile.memberSince} ===")
        println("*** ${userProfile.totalPoints} total points ***")
        println("*** ${userProfile.totalTruePoints} total true points ***")
        println("*** ${userProfile.totalSoftcorePoints} total softcore points ***")
    }
}