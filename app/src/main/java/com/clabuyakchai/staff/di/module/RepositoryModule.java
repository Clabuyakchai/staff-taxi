package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.HomeRepository;
import com.clabuyakchai.staff.data.repository.Impl.AuthRepositoryImpl;
import com.clabuyakchai.staff.data.repository.Impl.HomeRepositoryImpl;
import com.clabuyakchai.staff.data.repository.Impl.RouteRepositoryImpl;
import com.clabuyakchai.staff.data.repository.Impl.StationRepositoryImpl;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.data.repository.StationRepository;
import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.di.scope.ApplicationScope;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface RepositoryModule {
    @ApplicationScope
    @Binds
    AuthRepository bindAuthRepository(AuthRepositoryImpl authRepository);

    @ApplicationScope
    @Binds
    HomeRepository bindHomeRepository(HomeRepositoryImpl homeRepository);

    @ApplicationScope
    @Binds
    RouteRepository bindRouteRepository(RouteRepositoryImpl routeRepository);

    @ApplicationScope
    @Binds
    StationRepository bindStationRepository(StationRepositoryImpl stationRepository);
}
