package com.hanix.compose.composelayout.main_ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanix.compose.composelayout.R
import com.hanix.compose.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun AlignYourBodyElement(
    @DrawableRes image: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    ComposeLayoutTheme {
        AlignYourBodyElement(
            image = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
    }
}
//
//@Composable
//fun AlignYourBodyRow(modifier: Modifier = Modifier) {
//    LazyRow(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(horizontal = 16.dp)) {
//        items(alignYourBodyData) { item ->
//            AlignYourBodyElement(
//                image = item.drawable,
//                text = item.text,
//                modifier = modifier
//            )
//        }
//
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun AlignYourBodyRowPreview() {
//    ComposeLayoutTheme {
//        AlignYourBodyRow()
//    }
//}