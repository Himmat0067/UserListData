package com.himmat.userlistdata.di

import android.content.Context
import androidx.room.Room
import com.himmat.userlistdata.data.local.database.UserDatabase
import com.himmat.userlistdata.data.remote.WebApiService
import com.himmat.userlistdata.data.repository.GetUsersRepositoryImpl
import com.himmat.userlistdata.domain.repository.GetUsersRepository
import com.himmat.userlistdata.domain.use_cases.get_users.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDiModule {

    @Provides
    @Singleton
    fun provideWebApiService(retrofit: Retrofit): WebApiService{
        return retrofit.create(WebApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(webApiService: WebApiService): GetUsersRepository{
        return GetUsersRepositoryImpl(webApiService)
    }

    @Provides
    @Singleton
    fun provideGetUserUseCase(getUsersRepository: GetUsersRepository): GetUserListUseCase{
        return GetUserListUseCase(getUsersRepository)
    }

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase{
        return Room.databaseBuilder(context,UserDatabase::class.java,"users")
            .fallbackToDestructiveMigration()
            .build()
    }
}