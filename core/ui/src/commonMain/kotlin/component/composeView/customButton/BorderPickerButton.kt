package component.composeView.customButton

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import component.composeView.customTextField.CustomTextField
import component.composeView.otherViews.AnimatedBorderCard
import composeProvider.Dimens
import composeProvider.ProvideEverythingForPreview
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
internal fun CommonBorderPickerButton(
    value: String?,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    label: String? = null,
    onClick: (() -> Unit)? = null,
    isRequired: Boolean = false,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium),
        interactionSource = remember { MutableInteractionSource() }
            .also { interactionSource ->
                LaunchedEffect(interactionSource) {
                    interactionSource.interactions.collect {
                        if (it is PressInteraction.Release) {
                            keyboardController?.hide()
                            if (enabled) {
                                focusManager.clearFocus()
                            }
                            onClick?.invoke()
                        }
                    }
                }
            },
        label = label,
        isRequired = isRequired,
        value = value,
        enabled = enabled,
        readOnly = true,
        trailingIcon = {
            Icon(
                modifier = Modifier.size(Dimens.spaceLarge),
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null
            )
        },
        onValueChange = {}
    )
}