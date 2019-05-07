package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.Impl.AuthRepositoryImpl;
import com.clabuyakchai.staff.di.scope.ApplicationScope;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface RepositoryModule {
    @ApplicationScope
    @Binds
    AuthRepository provideAuthRepository(AuthRepositoryImpl authRepository);
}