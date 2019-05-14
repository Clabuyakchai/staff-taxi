package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface BookDetailFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    BookDetailFragment bindBookDetailFragment();
}
