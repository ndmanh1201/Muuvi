package com.app.muuvi.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.app.muuvi.core.ui.theme.muuviTheme
import com.app.muuvi.ui.theme.PrimaryColor
import com.app.muuvi.ui.theme.fontFamily

@Composable
fun muuviCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    description: String,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryColor,
                uncheckedColor = PrimaryColor,
                checkmarkColor = Color.White,
            )
        )
        Text(
            text = description,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun muuviCheckBoxCheckedPreview() {
    muuviTheme {
        muuviCheckBox(
            checked = true,
            description = "Remember me",
            onCheckedChange = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun muuviCheckBoxUnCheckedPreview() {
    muuviTheme {
        muuviCheckBox(
            checked = false,
            description = "Remember me",
            onCheckedChange = {},
        )
    }
}
