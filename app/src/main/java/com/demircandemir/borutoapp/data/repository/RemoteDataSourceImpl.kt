package com.demircandemir.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.demircandemir.borutoapp.data.local.BorutoDatabase
import com.demircandemir.borutoapp.data.paging_source.HeroRemoteMediator
import com.demircandemir.borutoapp.data.paging_source.SearchHeroesSource
import com.demircandemir.borutoapp.data.remote.BorutoApi
import com.demircandemir.borutoapp.domain.model.Hero
import com.demircandemir.borutoapp.domain.repositories.RemoteDataSource
import com.demircandemir.borutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
): RemoteDataSource {

    private val herDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { herDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi, query)
            }
        ).flow
    }
}