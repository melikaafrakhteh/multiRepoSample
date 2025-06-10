package theme

expect class ThemeObserver() {
    fun startObservingThemeChanges(onThemeChanged: (Boolean) -> Unit)
}