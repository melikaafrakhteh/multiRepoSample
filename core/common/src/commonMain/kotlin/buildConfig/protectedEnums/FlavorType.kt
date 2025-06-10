package buildConfig.protectedEnums

enum class FlavorType(val value: String) {
    NORMAL("normal"), TEST("test")
}

fun getFlavorTypeByName(value: String?): FlavorType? {
    return FlavorType.entries.firstOrNull { it.value.uppercase() == value?.uppercase() }
}