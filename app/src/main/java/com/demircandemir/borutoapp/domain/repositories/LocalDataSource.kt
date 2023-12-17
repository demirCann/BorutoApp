package com.demircandemir.borutoapp.domain.repositories

import com.demircandemir.borutoapp.data.remote.BorutoApi
import com.demircandemir.borutoapp.domain.model.Hero

interface LocalDataSource
 {
     suspend fun getSelectedHero(heroId: Int): Hero
}