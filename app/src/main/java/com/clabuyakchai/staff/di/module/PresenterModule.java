package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.interactor.AuthInteractor;
import com.clabuyakchai.staff.di.scope.ApplicationScope;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @ApplicationScope
    @Provides
    AuthPhonePresenterImpl provideAuthPhonePresenterImpl(){
        return new AuthPhonePresenterImpl();
    }
}
