package com.clabuyakchai.user.ui.activity.navigation;

import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.data.repository.HomeRepository;
import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.data.repository.StationRepository;
import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.di.scope.ApplicationScope;
import com.clabuyakchai.user.ui.fragment.navigation.bus.BusPresenter;
import com.clabuyakchai.user.ui.fragment.navigation.home.HomePresenter;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.NewRoutePresenter;
import com.clabuyakchai.user.ui.fragment.navigation.route.RoutePresenter;
import com.clabuyakchai.user.ui.fragment.navigation.routedetail.RouteDetailPresenter;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.TicketPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationActivityModule {
    @ActivityScope
    @Provides
    public HomePresenter provideHomePresenter(AuthRepository authRepository, HomeRepository homeRepository){
        return new HomePresenter(homeRepository, authRepository);
    }

    @ActivityScope
    @Provides
    public RoutePresenter provideRoutePresenter(RouteRepository routeRepository){
        return new RoutePresenter(routeRepository);
    }

    @ActivityScope
    @Provides
    public RouteDetailPresenter provideRouteDetailPresenter(RouteRepository routeRepository){
        return new RouteDetailPresenter(routeRepository);
    }

    @ActivityScope
    @Provides
    public BusPresenter provideBusPresenter(HomeRepository homeRepository){
        return new BusPresenter(homeRepository);
    }

    @ActivityScope
    @Provides
    public NewRoutePresenter provideNewRoutePresenter(StationRepository stationRepository, RouteRepository routeRepository){
        return new NewRoutePresenter(stationRepository, routeRepository);
    }

    @ActivityScope
    @Provides
    public TicketPresenter provideTicketPresenter(RouteRepository routeRepository){
        return new TicketPresenter(routeRepository);
    }
}
