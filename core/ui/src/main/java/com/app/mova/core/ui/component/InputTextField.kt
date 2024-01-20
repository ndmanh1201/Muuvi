package com.app.mova.core.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.mova.core.ui.R
import com.app.mova.core.ui.theme.MovaTheme
import com.app.mova.ui.theme.Grey50
import com.app.mova.ui.theme.Grey500
import com.app.mova.ui.theme.PrimaryColor
import com.app.mova.ui.theme.TransparentRed
import com.app.mova.ui.theme.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    @DrawableRes leadingIconResId: Int,
    trailingIconEnable: Boolean = false,
    hint: String,
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    onValueChange: (String) -> Unit,
) {
    val filledValueIconsColor = if (value.isNotEmpty()) {
        PrimaryColor
    } else {
        Grey500
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val trailingIconResId = if (trailingIconEnable) {
        R.drawable.icon_hide
    } else {
        R.drawable.icon_show
    }

    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            interactionSource = interactionSource,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = leadingIconResId),
                    contentDescription = null,
                    tint = filledValueIconsColor,
                )
            },
            trailingIcon = {
                if (trailingIconEnable) {
                    Icon(
                        modifier = Modifier.clickable { isPasswordVisible = !isPasswordVisible },
                        imageVector = ImageVector.vectorResource(id = trailingIconResId),
                        contentDescription = null,
                        tint = filledValueIconsColor,
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedLeadingIconColor = PrimaryColor,
                unfocusedLeadingIconColor = Grey500,
                focusedTrailingIconColor = PrimaryColor,
                unfocusedTrailingIconColor = Grey500,
            ),
            placeholder = {
                Text(
                    text = hint,
                    color = Grey500,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            },
            contentPadding = PaddingValues(20.dp),
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor = Grey50,
                        focusedContainerColor = TransparentRed,
                        unfocusedContainerColor = Grey50,
                    ),
                    shape = RoundedCornerShape(12.dp),
                    focusedBorderThickness = 1.dp,
                    unfocusedBorderThickness = 1.dp,
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputTextFieldPreview() {
    MovaTheme {
        InputTextField(
            value = "",
            onValueChange = {},
            leadingIconResId = R.drawable.icon_email,
            hint = "Email",
            trailingIconEnable = true,
        )
    }
}
