package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivityModule;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivityModule;
import com.clabuyakchai.user.ui.fragment.auth.code.AuthCodeFragmentProvider;
import com.clabuyakchai.user.ui.fragment.auth.phone.AuthPhoneFragmentProvider;
import com.clabuyakchai.user.ui.fragment.auth.registration.RegistrationFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.bookdetail.BookDetailFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.bus.BusFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.home.HomeFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.NewRouteFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.route.RouteFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.book.BookFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.routedetail.RouteDetailFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.station.StationFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.TicketFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.ticketdetail.TicketDetailFragment;
import com.clabuyakchai.user.ui.fragment.navigation.ticketdetail.TicketDetailFragmentProvider;
import com.clabuyakchai.user.ui.fragment.tab.TabNavigationFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {
            AuthActivityModule.class,
            AuthPhoneFragmentProvider.class,
            AuthCodeFragmentProvider.class,
            RegistrationFragmentProvider.class})
    public abstract AuthActivity bindLoginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            HomeFragmentProvider.class,
            RouteFragmentProvider.class,
            RouteDetailFragmentProvider.class,
            NavigationActivityModule.class,
            CiceroneModule.class,
            TabNavigationFragmentProvider.class,
            StationFragmentProvider.class,
            BusFragmentProvider.class,
            NewRouteFragmentProvider.class,
            BookFragmentProvider.class,
            BookDetailFragmentProvider.class,
            TicketFragmentProvider.class,
            TicketDetailFragmentProvider.class
    })
    public abstract NavigationActivity bindNavActivity();
}
