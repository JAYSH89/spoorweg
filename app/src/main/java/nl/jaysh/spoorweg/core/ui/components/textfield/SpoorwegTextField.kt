package nl.jaysh.spoorweg.core.ui.components.textfield

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SpoorwegTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    @DrawableRes leadingIcon: Int,
    @DrawableRes trailingIcon: Int,
    onValueChange: (String) -> Unit,
    onClickTrailingIcon: () -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedContainerColor = Color.Black,
            focusedContainerColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.inverseOnSurface,
            )
        },
        trailingIcon = {
            IconButton(
                onClick = onClickTrailingIcon,
                content = {
                    Icon(
                        painter = painterResource(id = trailingIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inverseOnSurface,
                    )
                },
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inverseOnSurface,
            )
        },
        onValueChange = onValueChange,
    )
}