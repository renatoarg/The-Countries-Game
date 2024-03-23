package com.renatoarg.composelist

import com.renatoarg.composelist.model.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object Di {

    @Provides
    fun providePersonRepository() : PersonRepository {
        return PersonRepository()
    }

}