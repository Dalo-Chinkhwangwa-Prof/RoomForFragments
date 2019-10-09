package com.example.roomforfragments.database

import androidx.room.*

@Dao
interface CelebrityDAO{
    @Query("SELECT * FROM my_celebrities")
    fun getAllCelebrities(): List<CelebrityEntity>

    @Delete
    fun deleteCelebrity(celebrityEntity: CelebrityEntity)


    @Update
    fun updateCelebrity(celebrityEntity: CelebrityEntity)

    @Insert
    fun insertAllCelebrities(vararg celebrityEntity: CelebrityEntity)
}