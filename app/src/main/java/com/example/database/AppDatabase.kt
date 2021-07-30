package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.entities.ReceiptsCompany
import com.example.database.entities.ReceiptsTax


//    This is the class for creating our database if not created or opening it if its already created.
@Database(
    entities = [ReceiptsCompany::class, ReceiptsTax::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    // Abstract Dao
    //abstract fun helloDao(): HellDao
    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }
        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            val appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "hello_db")
                .addCallback(object : RoomDatabase.Callback() {
                })
                .allowMainThreadQueries()
                .addMigrations()
                .build()
            return appDatabase
        }
    }
}