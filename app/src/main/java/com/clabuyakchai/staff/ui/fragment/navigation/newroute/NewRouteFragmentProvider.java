package com.clabuyakchai.staff.ui.fragment.navigation.newroute;

import com.clabuyakchai.staff.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface NewRouteFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    NewRouteFragment bindNewRouteFragment();
}
