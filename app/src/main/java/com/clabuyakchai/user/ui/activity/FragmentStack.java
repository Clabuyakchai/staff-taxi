package com.clabuyakchai.user.ui.activity;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

public interface FragmentStack {
    void add(Fragment fragment, Boolean addToBackStack);
    void pop();
}