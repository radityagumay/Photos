package com.radityalabs.photos.features.library

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class LibraryModule {

    @Binds
    @ActivityRetainedScoped
    internal abstract fun bindLibraryRepository(impl: DefaultLibraryRepository): LibraryRepository
}