package com.clabuyakchai.user.di.component;

import com.clabuyakchai.user.App;
import com.clabuyakchai.user.di.module.ActivityModule;
import com.clabuyakchai.user.di.module.ApplicationModule;
import com.clabuyakchai.user.di.module.DatabaseModule;
import com.clabuyakchai.user.di.module.FirebaseModule;
import com.clabuyakchai.user.di.module.RemoteModule;
import com.clabuyakchai.user.di.module.RepositoryModule;
import com.clabuyakchai.user.di.scope.ApplicationScope;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityModule.class,
        RemoteModule.class,
        FirebaseModule.class,
        RemoteModule.class,
        RepositoryModule.class,
        DatabaseModule.class,
        ApplicationModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
