package com.clabuyakchai.staff.di.module;

import android.content.Context;

import com.clabuyakchai.staff.App;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ApplicationModule {
    @ApplicationScope
    @Binds
    public abstract Context bindContext(App app);
}
