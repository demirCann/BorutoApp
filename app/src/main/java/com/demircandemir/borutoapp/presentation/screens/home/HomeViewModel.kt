package com.demircandemir.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.demircandemir.borutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val allHeroes = useCases.getAllHeroesUseCase()
}