package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.AuthActivity;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {
            AuthPhoneFragmentProvider.class,
            AuthCodeFragment.class})
    public abstract AuthActivity bindLoginActivity();
}
