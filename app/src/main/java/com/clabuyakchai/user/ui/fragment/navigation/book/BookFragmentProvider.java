package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface BookFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    BookFragment bindMyRouteFragment();
}
