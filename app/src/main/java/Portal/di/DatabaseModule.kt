package Portal.di

import Portal.a257.R
import Portal.database.Portal257Database
import Portal.database.dao.SportDao
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): Portal257Database {
        return Room.databaseBuilder(
            application,
            Portal257Database::class.java,
            application.getString(R.string.database)
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSportDao(portal257Database: Portal257Database): SportDao{
        return portal257Database.sportDao()
    }

}