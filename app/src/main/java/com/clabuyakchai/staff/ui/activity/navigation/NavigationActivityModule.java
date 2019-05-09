package com.clabuyakchai.staff.ui.activity.navigation;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.HomeRepository;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomePresenter;
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
}
