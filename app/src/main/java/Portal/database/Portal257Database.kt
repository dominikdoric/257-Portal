package Portal.database

import Portal.database.dao.*
import Portal.database.table.*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ZabavaTable::class,
        SportTable::class,
        ObavijestiTable::class,
        VijestiTable::class,
        OglasnikTable::class,
        NaslovnicaTable::class,
        PriceCitateljaTable::class,
        InfoTable::class,
        PoljoprivredaTable::class],
        version = 8,
        exportSchema = false
)
abstract class Portal257Database : RoomDatabase() {

    abstract fun zabavaDao(): ZabavaDao
    abstract fun sportDao(): SportDao
    abstract fun obavijestiDao(): ObavijestiDao
    abstract fun vijestiDao(): VijestiDao
    abstract fun oglasnikDao(): OglasnikDao
    abstract fun naslovnicaDao(): NaslovnicaDao
    abstract fun priceCitateljaDao(): PriceCitateljaDao
    abstract fun infoDao(): InfoDao
    abstract fun poljoprivredaDao(): PoljoprivredaDao


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