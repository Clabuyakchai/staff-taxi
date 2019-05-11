package com.clabuyakchai.staff.ui.fragment.navigation.bus;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface BusFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    BusFragment bindBusFragment();
}
