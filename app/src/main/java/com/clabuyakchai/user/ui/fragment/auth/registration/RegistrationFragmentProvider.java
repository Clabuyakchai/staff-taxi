package com.clabuyakchai.user.ui.fragment.auth.registration;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RegistrationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RegistrationFragment bindRegistrationFragment();
}
