package com.demircandemir.borutoapp.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.test.core.app.ApplicationProvider
import com.demircandemir.borutoapp.data.local.BorutoDatabase
import com.demircandemir.borutoapp.data.remote.FakeBorutoApi2
import com.demircandemir.borutoapp.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class HeroRemoteMediatorTest {

    private lateinit var borutoApi: FakeBorutoApi2
    private lateinit var borutoDatabase: BorutoDatabase

    @Before
    fun setup() {
        borutoApi = FakeBorutoApi2()
        borutoDatabase = BorutoDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanUp() {
        borutoDatabase.clearAllTables()
    }


    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            )

            val pagingState = PagingState<Int, Hero> (
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )

            val result = remoteMediator.load(LoadType.REFRESH, pagingState)

            assertTrue(result is RemoteMediator.MediatorResult.Success)
            assertFalse((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)

        }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnSuccessAndEndOfPaginationTrueWhenNoMoreData() =
        runBlocking {
            borutoApi.clearData()
            val remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            )

            val pagingState = PagingState<Int, Hero> (
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )

            val result = remoteMediator.load(LoadType.REFRESH, pagingState)

            assertTrue(result is RemoteMediator.MediatorResult.Success)
            assertTrue((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)

        }


    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() =
        runBlocking {
            borutoApi.addException()
            val remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            )

            val pagingState = PagingState<Int, Hero> (
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )

            val result = remoteMediator.load(LoadType.REFRESH, pagingState)

            assertTrue(result is RemoteMediator.MediatorResult.Error)

        }


}