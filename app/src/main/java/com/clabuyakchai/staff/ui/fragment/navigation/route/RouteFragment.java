package com.clabuyakchai.staff.ui.fragment.navigation.route;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RouteFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.route_fragment, container, false);
    }

    public static RouteFragment newInstance(){
        return new RouteFragment();
    }
}
