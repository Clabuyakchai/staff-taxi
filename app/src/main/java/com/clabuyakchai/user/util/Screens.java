package com.clabuyakchai.user.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.user.ui.fragment.navigation.bookdetail.BookDetailFragment;
import com.clabuyakchai.user.ui.fragment.navigation.bus.BusFragment;
import com.clabuyakchai.user.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.NewRouteFragment;
import com.clabuyakchai.user.ui.fragment.navigation.route.RouteFragment;
import com.clabuyakchai.user.ui.fragment.navigation.book.BookFragment;
import com.clabuyakchai.user.ui.fragment.navigation.routedetail.RouteDetailFragment;
import com.clabuyakchai.user.ui.fragment.navigation.station.StationFragment;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.TicketFragment;
import com.clabuyakchai.user.ui.fragment.navigation.ticketdetail.TicketDetailFragment;
import com.clabuyakchai.user.ui.fragment.tab.TabNavigationFragment;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static final class NavigationScreen extends SupportAppScreen{
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, NavigationActivity.class);
        }
    }

    public static final class HomeScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return HomeFragment.newInstance();
        }
    }

    public static final class RouteScreen extends SupportAppScreen{
        private final String name;

        public RouteScreen(String name) {
            this.name = name;
        }

        @Override
        public Fragment getFragment() {
            return RouteFragment.newInstance(name);
        }
    }

    public static final class RouteDetailScreen extends SupportAppScreen{
        private final Long timetableId;

        public RouteDetailScreen(Long timetableId) {
            this.timetableId = timetableId;
        }

        @Override
        public Fragment getFragment() {
            return RouteDetailFragment.newInstance(timetableId);
        }
    }

    public static final class StationScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return StationFragment.newInstance();
        }
    }

    public static final class TabScreen extends SupportAppScreen {
        private final String tabName;

        public TabScreen(String tabName) {
            this.tabName = tabName;
        }

        @Override
        public Fragment getFragment() {
            return TabNavigationFragment.newInstance(tabName);
        }
    }

    public static final class BusScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return BusFragment.newInstance();
        }
    }

    public static final class NewRouteScreen extends SupportAppScreen{
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public Fragment getFragment() {
            return NewRouteFragment.newInstance();
        }
    }

    public static final class BookScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return BookFragment.newInstance();
        }
    }

    public static final class BookDetailScreen extends SupportAppScreen {
        private final BookingDto bookingDto;

        public BookDetailScreen(BookingDto bookingDto) {
            this.bookingDto = bookingDto;
        }

        @Override
        public Fragment getFragment() {
            return BookDetailFragment.newInstance(bookingDto);
        }
    }

    public static final class TicketScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return TicketFragment.newInstance();
        }
    }

    public static final class TicketDetailScreen extends SupportAppScreen {
        private final RouteDto routeDto;

        public TicketDetailScreen(RouteDto routeDto) {
            this.routeDto = routeDto;
        }

        @Override
        public Fragment getFragment() {
            return TicketDetailFragment.newInstance(routeDto);
        }
    }
}
