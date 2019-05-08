package com.clabuyakchai.staff.ui.fragment.navigation.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
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
    @Inject
    @InjectPresenter
    HomePresenter presenter;

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

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }
}
