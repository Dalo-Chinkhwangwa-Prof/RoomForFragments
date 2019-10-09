package com.example.roomforfragments.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CelebrityEntity::class], version = 1)
abstract class CelebrityDatabase: RoomDatabase(){
    abstract fun celebrityDAO(): CelebrityDAO
}