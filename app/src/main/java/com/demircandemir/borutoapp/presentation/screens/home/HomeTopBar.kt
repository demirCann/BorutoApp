package com.demircandemir.borutoapp.presentation.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.demircandemir.borutoapp.R
import com.demircandemir.borutoapp.ui.theme.topAppBarBackgroundColor
import com.demircandemir.borutoapp.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick =  onSearchClicked) {
                Icon(
                    imageVector =Icons.Filled.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )
}


@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar {}
}