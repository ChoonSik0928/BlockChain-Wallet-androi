package com.choonsik.blockchainwallet.di.module

import android.app.Application
import com.choonsik.blockchainwallet.db.AppDatabase
import com.choonsik.blockchainwallet.db.dao.SecurityDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.getDatabase(application)
    }

    @Provides
    @Singleton
    fun provideSecurityDao(db: AppDatabase): SecurityDao {
        return db.getSecurityDao()
    }
}