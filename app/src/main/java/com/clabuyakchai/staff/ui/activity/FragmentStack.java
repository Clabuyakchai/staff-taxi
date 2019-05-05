package com.clabuyakchai.staff.ui.activity;

import androidx.fragment.app.Fragment;

public interface FragmentStack {
    void add(Fragment fragment, Boolean addToBackStack);
    void pop();
}
