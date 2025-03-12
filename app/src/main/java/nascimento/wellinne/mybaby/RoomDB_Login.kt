package com.aimirisolutions.prog3_2024_2

import androidx.room.Database
import androidx.room.RoomDatabase
import nascimento.wellinne.mybaby.RoomEntity_Login

@Database(entities = [RoomEntity_Login::class], version = 1)
abstract class RoomDB_Login: RoomDatabase() {

    abstract fun loginDao(): RoomDAO_Login
}