package de.renao

import de.renao.models.*
import kotlinx.serialization.json.Json
import java.io.InputStream

object ResourcesSettingsLoader {

    private const val SETTINGS_FILE_NAME = "ra-settings.json"

    fun loadSettings() : RASettings {
        val settingsText = readSettingsFromResources()
        return Json.decodeFromString<RASettings>(settingsText)
    }

    private fun readSettingsFromResources(): String {
        val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("/$SETTINGS_FILE_NAME")
        return inputStream?.bufferedReader()?.use { it.readText() }
            ?: throw IllegalArgumentException("File not found: $SETTINGS_FILE_NAME")
    }

}