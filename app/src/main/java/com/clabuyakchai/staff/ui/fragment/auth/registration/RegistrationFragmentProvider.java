package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RegistrationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RegistrationFragment bindRegistrationFragment();
}
