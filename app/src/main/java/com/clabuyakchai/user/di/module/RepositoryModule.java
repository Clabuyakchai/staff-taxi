package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.data.repository.HomeRepository;
import com.clabuyakchai.user.data.repository.Impl.AuthRepositoryImpl;
import com.clabuyakchai.user.data.repository.Impl.BookRepositoryImpl;
import com.clabuyakchai.user.data.repository.Impl.HomeRepositoryImpl;
import com.clabuyakchai.user.data.repository.Impl.RouteRepositoryImpl;
import com.clabuyakchai.user.data.repository.Impl.StationRepositoryImpl;
import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.data.repository.StationRepository;
import com.clabuyakchai.user.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

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

    @ApplicationScope
    @Binds
    BookRepository bindBookRepository(BookRepositoryImpl bookRepository);
}
