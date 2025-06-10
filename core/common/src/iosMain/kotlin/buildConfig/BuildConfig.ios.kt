package buildConfig

import buildConfig.protectedEnums.FlavorType
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
actual fun isDebugBuild(): Boolean {
    return Platform.isDebugBinary
}

actual fun getFlavorType(): FlavorType {
    return FlavorType.NORMAL
}