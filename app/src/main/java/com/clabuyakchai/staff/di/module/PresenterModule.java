package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.di.scope.ApplicationScope;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @ApplicationScope
    @Provides
    public AuthPhonePresenter provideAuthPhonePresenterImpl(AuthRepository authRepository){
        return new AuthPhonePresenter(authRepository);
    }

    @ApplicationScope
    @Provides
    public AuthCodePresenter provideAuthCodePresenter(AuthRepository authRepository){
        return new AuthCodePresenter(authRepository);
    }

    @ApplicationScope
    @Provides
    public RegistrationPresenter provideRegistrationPresenter(AuthRepository authRepository){
        return new RegistrationPresenter(authRepository);
    }
}
