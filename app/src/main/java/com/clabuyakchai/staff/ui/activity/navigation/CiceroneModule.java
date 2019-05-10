package com.clabuyakchai.staff.ui.activity.navigation;

import com.clabuyakchai.staff.di.scope.ActivityScope;

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
}
