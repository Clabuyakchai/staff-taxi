package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface TicketDetailFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    TicketDetailFragment bindTicketDetailFragment();
}
