package com.clabuyakchai.user.ui.fragment.navigation.station;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface StationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    StationFragment bindStationFragment();
}
