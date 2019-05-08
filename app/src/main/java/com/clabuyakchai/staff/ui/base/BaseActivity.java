package com.clabuyakchai.staff.ui.base;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.FragmentStack;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity implements FragmentStack {
    protected FragmentManager fm = getSupportFragmentManager();
    @IdRes
    protected Integer idConteiner;

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
