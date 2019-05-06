package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.Impl.AuthRepositoryImpl;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {
    @ApplicationScope
    @Binds
    AuthRepository bindAuthRepository(AuthRepositoryImpl authRepository);
}
