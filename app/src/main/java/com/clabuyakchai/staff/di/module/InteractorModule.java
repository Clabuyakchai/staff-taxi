package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.interactor.AuthInteractor;
import com.clabuyakchai.staff.data.interactor.Impl.AuthInteractorImpl;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

@Module
public interface InteractorModule {
    @ApplicationScope
    @Binds
    AuthInteractor bindAuthInteractor(AuthInteractorImpl authInteractor);
}
