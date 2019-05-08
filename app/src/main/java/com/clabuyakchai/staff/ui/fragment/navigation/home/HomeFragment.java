package com.clabuyakchai.staff.ui.fragment.navigation.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.util.MyServiceInterceptor;
import com.clabuyakchai.staff.util.Preferences;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeFragment extends BaseFragment implements HomeView {

    private EditText nameEdtx;
    private EditText phoneEdtx;
    private EditText emailEdtx;
    private EditText addressEdtx;
    private TextView changeUserTxt;

    @Inject
    @InjectPresenter
    HomePresenter presenter;
    private StartActivity startAuthActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof NavigationActivity){
            startAuthActivity = (NavigationActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();

        nameEdtx = view.findViewById(R.id.home_name);
        phoneEdtx = view.findViewById(R.id.home_phone);
        emailEdtx = view.findViewById(R.id.home_email);
        addressEdtx = view.findViewById(R.id.home_address);
        changeUserTxt = view.findViewById(R.id.change_user);
        changeUserTxt.setOnClickListener(view1 -> {
            presenter.signOut();
        });
    }

    @ProvidePresenter
    HomePresenter provideHomePresenter(){
        return presenter;
    }

    @Override
    public void setField(StaffDto staffDto) {
        nameEdtx.setText(staffDto.getName());
        phoneEdtx.setText(staffDto.getPhone());
        emailEdtx.setText(staffDto.getEmail());
        addressEdtx.setText(staffDto.getAddress());
    }

    @Override
    public void signOut() {
        Preferences.setTokenSharedPreferences(getContext(), null);
        presenter.deleteStaffFromDb();
        startAuthActivity.startActivity();
    }

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onDetach() {
        startAuthActivity = null;
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }
}
