package com.clabuyakchai.user.ui.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.util.Screens;
import com.clabuyakchai.user.R;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class TabNavigationFragment extends BaseFragment implements RouterProvider{
    private static final String EXTRA_NAME = "tcf_extra_name";

    private Navigator navigator;

    @Inject
    LocalCiceroneHolder ciceroneHolder;

    public static TabNavigationFragment newInstance(String name) {
        TabNavigationFragment fragment = new TabNavigationFragment();

        Bundle args = new Bundle();
        args.putString(EXTRA_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    private Cicerone<Router> getCicerone() {
        return ciceroneHolder.getCicerone(getContainerName());
    }

    private String getContainerName() {
        return getArguments().getString(EXTRA_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_container, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getContainerName().equals("Route")) {
            getCicerone().getRouter().replaceScreen(new Screens.RouteScreen(getContainerName()));
        } else if (getContainerName().equals("Station")) {
            getCicerone().getRouter().replaceScreen(new Screens.StationScreen());
        } else if (getContainerName().equals("Home")) {
            getCicerone().getRouter().replaceScreen(new Screens.HomeScreen());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getCicerone().getNavigatorHolder().setNavigator(getNavigator());
    }

    @Override
    public void onPause() {
        getCicerone().getNavigatorHolder().removeNavigator();
        super.onPause();
    }

    @Override
    public Router getRouter() {
        return getCicerone().getRouter();
    }

    private Navigator getNavigator() {
        if (navigator == null) {
            navigator = new SupportAppNavigator(getActivity(), getChildFragmentManager(), R.id.tab_container);
        }
        return navigator;
    }
}
