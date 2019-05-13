package com.clabuyakchai.user.ui.activity.auth;

import android.content.Intent;
import android.os.Bundle;

import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.user.ui.base.BaseActivity;
import com.clabuyakchai.user.ui.fragment.auth.phone.AuthPhoneFragment;
import com.clabuyakchai.user.R;

import androidx.fragment.app.Fragment;

public class AuthActivity extends BaseActivity implements StartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        idConteiner = R.id.container_auth;

        Fragment fragment = fm.findFragmentById(R.id.container_auth);
        if(fragment == null){
            add(AuthPhoneFragment.newInstance(), false);
        }
    }

    @Override
    public void startActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setIdConteiner() {
        idConteiner = R.id.container_auth;
    }
}
