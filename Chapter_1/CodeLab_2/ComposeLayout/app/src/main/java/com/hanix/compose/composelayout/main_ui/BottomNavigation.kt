package com.hanix.compose.composelayout.main_ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanix.compose.composelayout.R
import com.hanix.compose.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    var tabPosition = rememberSaveable { mutableStateOf(true) }
    NavigationBar(modifier = Modifier, containerColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(
            selected = tabPosition.value,
            onClick = { tabPosition.value = !tabPosition.value },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            }
        )
        NavigationBarItem(
            selected = !tabPosition.value,
            onClick = { tabPosition.value = !tabPosition.value },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.bottom_navigation_profile)) }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    ComposeLayoutTheme { BottomNavigation(Modifier.padding(top = 24.dp)) }
}