package dev.zotov.todoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TodoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoData

    companion object {
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return if (INSTANCE == null) {
                Room.databaseBuilder(
                    context,
                    TodoDatabase::class.java,
                    "user_database"
                ).build()
            } else {
                INSTANCE!!
            }
        }
    }

}