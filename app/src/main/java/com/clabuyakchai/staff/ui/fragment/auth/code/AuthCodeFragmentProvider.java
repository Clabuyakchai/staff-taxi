package com.clabuyakchai.staff.ui.fragment.auth.code;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AuthCodeFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    AuthCodeFragment bindAuthCodeFragment();
}
