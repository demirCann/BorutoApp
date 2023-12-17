package com.demircandemir.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demircandemir.borutoapp.util.Constants.HERO_REMOTE_KEYS_DATABASE

@Entity(tableName = HERO_REMOTE_KEYS_DATABASE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long? = null
)
