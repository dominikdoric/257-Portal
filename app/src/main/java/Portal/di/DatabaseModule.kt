package Portal.di

import Portal.a257.R
import Portal.database.Portal257Database
import Portal.database.dao.SportDao
import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        Portal257Database::class.java,
        "portal_257"
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideInfoDao(portal257Database: Portal257Database) = portal257Database.infoDao()

    @Provides
    @Singleton
    fun provideSportDao(portal257Database: Portal257Database) = portal257Database.sportDao()

    @Provides
    @Singleton
    fun provideZabavaDao(portal257Database: Portal257Database) = portal257Database.zabavaDao()

    @Provides
    @Singleton
    fun provideVijestiDao(portal257Database: Portal257Database) = portal257Database.vijestiDao()

    @Provides
    @Singleton
    fun providePriceCitateljaDao(portal257Database: Portal257Database) = portal257Database.priceCitateljaDao()

    @Provides
    @Singleton
    fun provideOglasnikDao(portal257Database: Portal257Database) = portal257Database.oglasnikDao()

    @Provides
    @Singleton
    fun provideObavijestiDao(portal257Database: Portal257Database) = portal257Database.obavijestiDao()

}