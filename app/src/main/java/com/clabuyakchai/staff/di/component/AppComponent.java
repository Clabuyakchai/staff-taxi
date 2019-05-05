package com.clabuyakchai.staff.di.component;

import com.clabuyakchai.staff.App;
import com.clabuyakchai.staff.di.module.ActivityModule;
import com.clabuyakchai.staff.di.module.FirebaseModule;
import com.clabuyakchai.staff.di.module.RemoteModule;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityModule.class,
        RemoteModule.class,
        FirebaseModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
