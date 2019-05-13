package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class CiceroneModule {

    @ActivityScope
    @Provides
    public Cicerone<Router> provideCicerone(){
        return Cicerone.create();
    }

    @ActivityScope
    @Provides
    public NavigatorHolder provideNavigatorHolder(Cicerone<Router> cicerone){
        return cicerone.getNavigatorHolder();
    }

    @ActivityScope
    @Provides
    public Router provideRouter(Cicerone<Router> cicerone){
        return cicerone.getRouter();
    }

    @ActivityScope
    @Provides
    public LocalCiceroneHolder provideLocalCiceroneHolder(){
        return new LocalCiceroneHolder();
    }
}
