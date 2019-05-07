package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivityModule;
import com.clabuyakchai.staff.ui.activity.nav.NavActivity;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {
            AuthActivityModule.class,
            AuthPhoneFragmentProvider.class,
            AuthCodeFragmentProvider.class,
            RegistrationFragmentProvider.class})
    public abstract AuthActivity bindLoginActivity();

    @ActivityScope
    @ContributesAndroidInjector
    public abstract NavActivity bindNavActivity();
}
