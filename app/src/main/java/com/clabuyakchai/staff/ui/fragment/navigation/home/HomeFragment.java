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
import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
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
    private TextView editTxt;
    private TextView saveTxt;

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
        editTxt = view.findViewById(R.id.edit_user);
        saveTxt = view.findViewById(R.id.save_user);

        editTxt.setOnClickListener(v -> {
            presenter.pressEditUser(true);
        });

        saveTxt.setOnClickListener(v -> {
            presenter.pressEditUser(false);
            Staff staff = new Staff();
            staff.setName(nameEdtx.getText().toString());
            staff.setPhone(phoneEdtx.getText().toString());
            staff.setEmail(emailEdtx.getText().toString());
            staff.setAddress(addressEdtx.getText().toString());
            presenter.updateUser(staff);
        });

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
        startAuthActivity.startActivity();
    }

    @Override
    public void setEnabledEdTxt(Boolean enabled) {
        nameEdtx.setEnabled(enabled);
        phoneEdtx.setEnabled(enabled);
        emailEdtx.setEnabled(enabled);
        addressEdtx.setEnabled(enabled);
        if (enabled) {
            editTxt.setVisibility(View.GONE);
            saveTxt.setVisibility(View.VISIBLE);
        } else {
            editTxt.setVisibility(View.VISIBLE);
            saveTxt.setVisibility(View.GONE);
        }
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
