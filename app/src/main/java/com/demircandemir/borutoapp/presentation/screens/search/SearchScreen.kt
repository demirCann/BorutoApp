package com.demircandemir.borutoapp.presentation.screens.search

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.demircandemir.borutoapp.navigation.Screen
import com.demircandemir.borutoapp.presentation.common.ListContent
import com.demircandemir.borutoapp.ui.theme.statusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.statusBarColor
    )

    Scaffold(
        topBar = {
            SearchAppBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(newQuery = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)
                }
            )
        },
        content = {
            ListContent(heroes = heroes, navController = navController)
        }
    )
}