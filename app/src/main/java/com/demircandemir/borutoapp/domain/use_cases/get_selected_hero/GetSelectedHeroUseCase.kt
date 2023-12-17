package com.demircandemir.borutoapp.domain.use_cases.get_selected_hero

import com.demircandemir.borutoapp.data.repository.Repository
import com.demircandemir.borutoapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}