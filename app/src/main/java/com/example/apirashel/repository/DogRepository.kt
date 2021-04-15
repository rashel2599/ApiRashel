package com.example.apirashel.repository

import com.example.apirashel.retrofit.DogRetrofit
import com.example.apirashel.retrofit.NetworkMapper
import com.example.apirashel.room.CacheMapper
import com.example.apirashel.room.DogDao
import com.example.apirashel.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow

class DogRepository constructor(
    private val dogDao: DogDao,
    private val dogRetrofit: DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getDogs(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val dogData = dogRetrofit.get()
            val dogMap = networkMapper.mapFromEntityList(dogData)
            for (tempDog in dogMap){
                dogDao.insert(cacheMapper.mapToEntity(tempDog))
            }
            val cacheDog = dogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheDog)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }


}