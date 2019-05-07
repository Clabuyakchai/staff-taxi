package com.clabuyakchai.staff.ui.activity.auth;

import android.content.Intent;
import android.os.Bundle;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.nav.NavActivity;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements FragmentStack, StartActivity {

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
                .replace(R.id.container_login, fragment);

        if(addToBackStack){
            ft.addToBackStack(fragment.getClass().getName());
        }

        ft.commit();
    }

    @Override
    public void pop() {
        fm.popBackStack();
    }

    @Override
    public void startActivity() {
        Intent intent = new Intent(this, NavActivity.class);
        startActivity(intent);
        finish();
    }
}
