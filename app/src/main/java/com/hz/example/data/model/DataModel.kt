package com.hz.example.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String="",
    val description: String="",
    @Ignore
    override val size: Int
) : List<DataModel> {
    override fun contains(element: DataModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<DataModel>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): DataModel {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<DataModel> {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<DataModel> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<DataModel> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<DataModel> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: DataModel): Int {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: DataModel): Int {
        TODO("Not yet implemented")
    }
}