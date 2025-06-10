package buildConfig

import buildConfig.protectedEnums.FlavorType

actual fun isDebugBuild(): Boolean {
    return false
}

actual fun getFlavorType(): FlavorType {
    return  FlavorType.NORMAL
}