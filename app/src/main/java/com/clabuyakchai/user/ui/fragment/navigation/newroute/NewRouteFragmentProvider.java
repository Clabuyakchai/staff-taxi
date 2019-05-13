package com.clabuyakchai.user.ui.fragment.navigation.newroute;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface NewRouteFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    NewRouteFragment bindNewRouteFragment();
}
