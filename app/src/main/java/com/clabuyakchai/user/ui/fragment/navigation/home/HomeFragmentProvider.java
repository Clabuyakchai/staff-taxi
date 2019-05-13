package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface HomeFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    HomeFragment bindHomeFragment();
}
