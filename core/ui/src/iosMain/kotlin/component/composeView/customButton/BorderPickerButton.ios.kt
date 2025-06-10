package component.composeView.customButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import component.composeView.customTextField.CustomTextField
import component.composeView.otherViews.RequiredView
import composeProvider.Dimens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun BorderPickerButton(
    value: String?,
    modifier: Modifier,
    label: String?,
    onClick: (() -> Unit)?,
    enabled: Boolean,
    isRequired: Boolean
) {
    val expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            onClick?.invoke()
        },
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                .clip(MaterialTheme.shapes.medium),
            label = label,
            value = value,
            readOnly = true,
            trailingIcon = {
                Row(
                    modifier = Modifier.requiredWidthIn(min = Dimens.spaceXLarge),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null
                    )

                    if (isRequired) {
                        RequiredView(
                            modifier = Modifier
                        )
                    }
                }
            },
            onValueChange = {}
        )
    }
}