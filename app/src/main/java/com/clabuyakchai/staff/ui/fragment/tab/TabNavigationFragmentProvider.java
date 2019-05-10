package com.clabuyakchai.staff.ui.fragment.tab;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface TabNavigationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    TabNavigationFragment bindTabNavigationFragment();
}
