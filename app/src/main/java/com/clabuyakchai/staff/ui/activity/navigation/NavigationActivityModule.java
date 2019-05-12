package com.clabuyakchai.staff.ui.activity.navigation;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.HomeRepository;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.data.repository.StationRepository;
import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.fragment.navigation.bus.BusPresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.NewRoutePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RoutePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailPresenter;

import dagger.Module;
import dagger.Provides;

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
}
