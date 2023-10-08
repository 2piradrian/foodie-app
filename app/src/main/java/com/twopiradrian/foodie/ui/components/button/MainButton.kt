package com.twopiradrian.foodie.ui.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainButton(
        isEnabled: Boolean,
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 16.dp)) {
        Button(
                // values
                enabled = isEnabled,
                onClick = onClick,
                // styles
                colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
        )
        {
            Text(
                    // values
                    text = text,
                    // styles
                    style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp
                    ),
            )
        }
    }
}