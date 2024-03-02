package com.app.muuvi.core.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.muuvi.core.ui.R
import com.app.muuvi.core.ui.theme.muuviTheme
import com.app.muuvi.ui.theme.DisabledButtonColor
import com.app.muuvi.ui.theme.fontFamily

@Composable
fun muuviButton(
    modifier: Modifier = Modifier,
    title: String,
    color: Color,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
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

@Preview(showBackground = true)
@Composable
fun muuviButtonPreview() {
    muuviTheme {
        muuviButton(
            onClick = {},
            title = stringResource(id = R.string.sign_up),
            color = DisabledButtonColor,
        )
    }
}
