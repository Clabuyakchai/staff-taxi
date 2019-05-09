package com.clabuyakchai.staff.di.component;

import com.clabuyakchai.staff.App;
import com.clabuyakchai.staff.di.module.ActivityModule;
import com.clabuyakchai.staff.di.module.ApplicationModule;
import com.clabuyakchai.staff.di.module.DatabaseModule;
import com.clabuyakchai.staff.di.module.FirebaseModule;
import com.clabuyakchai.staff.di.module.RemoteModule;
import com.clabuyakchai.staff.di.module.RepositoryModule;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

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
