package com.demircandemir.borutoapp.domain.repositories

import androidx.paging.PagingData
import com.demircandemir.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}