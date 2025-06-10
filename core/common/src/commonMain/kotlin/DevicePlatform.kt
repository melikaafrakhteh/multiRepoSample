
enum class DevicePlatform(val value: String) {
    ANDROID("ANDROID"),
    IOS("IOS"),
    PWA("PWA")
}

expect fun getPlatformType(): DevicePlatform