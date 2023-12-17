package com.demircandemir.borutoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demircandemir.borutoapp.data.local.BorutoDatabase
import com.demircandemir.borutoapp.data.repository.LocalDataSourceImpl
import com.demircandemir.borutoapp.domain.repositories.LocalDataSource
import com.demircandemir.borutoapp.util.Constants.BORUTO_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : BorutoDatabase {
        return Room.databaseBuilder(
            context,
            BorutoDatabase::class.java,
            BORUTO_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        borutoDatabase: BorutoDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(borutoDatabase = borutoDatabase)
    }
}