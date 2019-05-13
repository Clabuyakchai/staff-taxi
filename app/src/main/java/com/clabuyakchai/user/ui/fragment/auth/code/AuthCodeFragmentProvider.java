package com.clabuyakchai.user.ui.fragment.auth.code;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AuthCodeFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    AuthCodeFragment bindAuthCodeFragment();
}
