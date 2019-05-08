package com.clabuyakchai.staff.ui.fragment.navigation.route;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RouteFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RouteFragment bindRouteFragment();
}
