package com.clabuyakchai.staff.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;

public class AuthActivity extends DaggerAppCompatActivity implements FragmentStack {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_login);
        if(fragment == null){
            add(AuthPhoneFragment.newInstance(), false);
        }
    }

    @Override
    public void add(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.container_login, fragment);

        if(addToBackStack){
            ft.addToBackStack(fragment.getClass().getName());
        }

        ft.commit();
    }

    @Override
    public void pop() {
        fm.popBackStack();
    }
}
