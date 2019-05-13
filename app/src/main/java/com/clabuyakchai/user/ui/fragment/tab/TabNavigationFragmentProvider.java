package com.clabuyakchai.user.ui.fragment.tab;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface TabNavigationFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    TabNavigationFragment bindTabNavigationFragment();
}
