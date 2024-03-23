package com.renatoarg.composelist

import androidx.lifecycle.SavedStateHandle
import com.renatoarg.composelist.model.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@Module
@InstallIn(ViewModelComponent::class)
object DiModule {

    @Provides
    @ViewModelScoped
    fun  providePersonRepo(handle: SavedStateHandle) = PersonRepository()

    class PersonListFetcher @Inject constructor(
        val personRepo : PersonRepository
    )

}