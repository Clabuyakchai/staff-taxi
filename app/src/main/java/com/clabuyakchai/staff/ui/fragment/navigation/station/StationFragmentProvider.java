package com.clabuyakchai.staff.ui.fragment.navigation.station;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface StationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    StationFragment bindStationFragment();
}
