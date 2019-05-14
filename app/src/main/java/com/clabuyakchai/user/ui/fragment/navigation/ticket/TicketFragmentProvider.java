package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface TicketFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    TicketFragment bindTicketFragment();
}
