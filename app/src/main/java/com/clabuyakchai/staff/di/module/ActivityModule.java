package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivityModule;
import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragmentProvider;

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
    @ContributesAndroidInjector(modules = {
            HomeFragmentProvider.class,
            RouteFragmentProvider.class
    })
    public abstract NavigationActivity bindNavActivity();
}
