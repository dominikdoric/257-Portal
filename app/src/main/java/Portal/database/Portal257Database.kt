package Portal.database

import Portal.database.dao.*
import Portal.database.table.*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        OglasnikTable::class,
        InfoTable::class],
        version = 13,
        exportSchema = false
)
abstract class Portal257Database : RoomDatabase() {

    abstract fun oglasnikDao(): OglasnikDao
    abstract fun infoDao(): InfoDao


    companion object {
        @Volatile
        private var INSTANCE: Portal257Database? = null

        fun getDatabase(context: Context): Portal257Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Portal257Database::class.java,
                    "nk_jaksic_baza"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}