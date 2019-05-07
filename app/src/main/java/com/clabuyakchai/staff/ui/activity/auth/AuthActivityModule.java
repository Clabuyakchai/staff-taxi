package com.clabuyakchai.staff.ui.activity.auth;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;

import dagger.Binds;
import dagger.Module;

@Module
public interface AuthActivityModule {
    @ActivityScope
    @Binds
    FragmentStack bindFragmentStack(AuthActivity authActivity);
}

