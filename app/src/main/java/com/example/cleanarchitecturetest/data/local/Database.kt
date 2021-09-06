package com.example.cleanarchitecturetest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cleanarchitecturetest.data.local.dao.BookItemDao
import com.example.cleanarchitecturetest.domain.entity.BookItem

@Database(entities = [BookItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database: RoomDatabase() {
    abstract fun bookItemDao(): BookItemDao
}