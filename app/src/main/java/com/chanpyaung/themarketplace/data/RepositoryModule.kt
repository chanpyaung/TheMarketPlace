package com.chanpyaung.themarketplace.data

import com.chanpyaung.themarketplace.data.repository.DataRepository
import com.chanpyaung.themarketplace.data.repository.DataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDataRepository(
        impl: DataRepositoryImpl
    ): DataRepository

}