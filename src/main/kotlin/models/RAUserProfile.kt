package de.renao.models

import org.retroachivements.api.data.pojo.user.GetUserProfile

class RAUserProfile(response: GetUserProfile.Response) {

    val name: String = response.user
    val id: Long = response.id
    val pathToPicture : String = response.userPic
    val memberSince : String = response.memberSince
    val totalPoints : Int = response.totalPoints
    val totalTruePoints : Long = response.totalTruePoints
    val totalSoftcorePoints : Int = response.totalSoftcorePoints
}