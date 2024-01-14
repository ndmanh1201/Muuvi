package com.app.mova.core.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.mova.ui.theme.PrimaryColor
import com.app.mova.ui.theme.fontFamily

@Composable
fun ButtonPrimaryColor(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
        ),
        contentPadding = PaddingValues(16.dp),
    ) {
        Text(
            text = title,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun ButtonPrimaryColorPreview() {
    ButtonPrimaryColor(
        onClick = {},
        title = "Test"
    )
}
