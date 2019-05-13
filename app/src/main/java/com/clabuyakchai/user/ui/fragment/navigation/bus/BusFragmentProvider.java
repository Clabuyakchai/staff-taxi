package com.clabuyakchai.user.ui.fragment.navigation.bus;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface BusFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    BusFragment bindBusFragment();
}
