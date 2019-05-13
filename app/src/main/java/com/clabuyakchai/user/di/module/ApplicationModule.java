package com.clabuyakchai.user.di.module;

import android.content.Context;

import com.clabuyakchai.user.App;
import com.clabuyakchai.user.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {
    @ApplicationScope
    @Binds
    public abstract Context bindContext(App app);
}