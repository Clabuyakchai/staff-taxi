package com.clabuyakchai.user.ui.fragment.navigation.route;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RouteFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RouteFragment bindRouteFragment();
}
