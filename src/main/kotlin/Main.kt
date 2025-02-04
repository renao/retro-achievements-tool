package de.renao

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val settings = loadSettings()
    }
fun loadSettings() : RASettings {
    val settingsText = loadFromResources("ra-settings.json")
    return Json.decodeFromString<RASettings>(settingsText)
}

fun loadFromResources(fileName: String): String {
    val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("/$fileName")
    return inputStream?.bufferedReader()?.use { it.readText() }
        ?: throw IllegalArgumentException("File not found: $fileName")
}