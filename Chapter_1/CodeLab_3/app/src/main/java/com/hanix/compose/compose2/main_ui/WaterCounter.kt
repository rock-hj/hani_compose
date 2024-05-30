package com.hanix.compose.compose2.main_ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hanix.compose.compose2.R

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 0
    Text(
        text = stringResource(R.string.count_glass, count),
        modifier = modifier.padding(16.dp)
    )
}