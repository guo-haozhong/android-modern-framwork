package com.hz.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hz.example.data.model.DataModel
import org.jetbrains.annotations.NotNull

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<DataModel>)

    @Query("SELECT * FROM data_table")
    @NotNull
    suspend fun getData(): List<DataModel>
}