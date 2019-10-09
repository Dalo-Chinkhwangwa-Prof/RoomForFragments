package com.example.roomforfragments.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_celebrities")
data class CelebrityEntity(
    @PrimaryKey(autoGenerate = true) var primaryKey: Int?,
    @ColumnInfo(name = "celebrity_name") var celebName: String,
    @ColumnInfo(name = "celebrity_industry") var celebIndustry: String
) {
    constructor(
        celebrityName: String,
        celebrityIndustry: String
    ) : this(null, celebrityName, celebrityIndustry)
}