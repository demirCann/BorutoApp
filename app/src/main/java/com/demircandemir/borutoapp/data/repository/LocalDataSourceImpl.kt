package com.demircandemir.borutoapp.data.repository

import com.demircandemir.borutoapp.data.local.BorutoDatabase
import com.demircandemir.borutoapp.domain.model.Hero
import com.demircandemir.borutoapp.domain.repositories.LocalDataSource

class LocalDataSourceImpl(
    private val borutoDatabase: BorutoDatabase
): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}