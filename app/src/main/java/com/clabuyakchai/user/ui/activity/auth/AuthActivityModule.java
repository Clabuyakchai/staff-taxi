package com.clabuyakchai.user.ui.activity.auth;

import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.ui.activity.FragmentStack;
import com.clabuyakchai.user.ui.fragment.auth.code.AuthCodePresenter;
import com.clabuyakchai.user.ui.fragment.auth.phone.AuthPhonePresenter;
import com.clabuyakchai.user.ui.fragment.auth.registration.RegistrationPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AuthActivityModule {
    @ActivityScope
    @Binds
    abstract FragmentStack bindFragmentStack(AuthActivity authActivity);

    @ActivityScope
    @Provides
    public static AuthPhonePresenter provideAuthPhonePresenterImpl(AuthRepository authRepository){
        return new AuthPhonePresenter(authRepository);
    }

    @ActivityScope
    @Provides
    public static AuthCodePresenter provideAuthCodePresenter(AuthRepository authRepository){
        return new AuthCodePresenter(authRepository);
    }

    @ActivityScope
    @Provides
    public static RegistrationPresenter provideRegistrationPresenter(AuthRepository authRepository){
        return new RegistrationPresenter(authRepository);
    }
}

