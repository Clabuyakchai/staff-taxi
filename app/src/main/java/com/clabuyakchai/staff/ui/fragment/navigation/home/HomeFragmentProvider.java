package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface HomeFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    HomeFragment bindHomeFragment();
}
