package com.clabuyakchai.user.ui.base;

import android.content.Context;
import android.os.Bundle;

import com.clabuyakchai.user.ui.activity.FragmentStack;

import javax.inject.Inject;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity extends MvpAppCompatActivity implements FragmentStack, HasFragmentInjector, HasSupportFragmentInjector {
    protected FragmentManager fm = getSupportFragmentManager();
    @IdRes
    protected Integer idConteiner;
    @Inject DispatchingAndroidInjector<Fragment> supportFragmentInjector;
    @Inject DispatchingAndroidInjector<android.app.Fragment> frameworkFragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return frameworkFragmentInjector;
    }


    @Override
    public void add(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction ft = fm.beginTransaction()
                .replace(idConteiner, fragment);

        if(addToBackStack){
            ft.addToBackStack(fragment.getClass().getName());
        }

        ft.commit();
    }

    @Override
    public void pop() {
        fm.popBackStack();
    }

    public abstract void setIdConteiner();
}
