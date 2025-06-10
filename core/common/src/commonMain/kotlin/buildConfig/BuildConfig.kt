package buildConfig

import buildConfig.protectedEnums.FlavorType

expect fun isDebugBuild(): Boolean

expect fun getFlavorType(): FlavorType

