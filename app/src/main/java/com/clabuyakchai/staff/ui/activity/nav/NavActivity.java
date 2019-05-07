package com.clabuyakchai.staff.ui.activity.nav;

import android.os.Bundle;

import com.clabuyakchai.staff.R;

import androidx.annotation.Nullable;
import dagger.android.support.DaggerAppCompatActivity;

public class NavActivity extends DaggerAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
    }
}
