package com.clabuyakchai.user.ui.fragment.navigation.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.clabuyakchai.user.util.Preferences;
import com.clabuyakchai.user.R;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeFragment extends BaseFragment implements HomeView, BackButtonListener {

    private EditText nameEdtx;
    private EditText phoneEdtx;
    private EditText emailEdtx;
    private EditText addressEdtx;
    private EditText busEdtx;
    private Button changeUserBtn;
    private TextView editTxt;
    private TextView addStaffTxt;
    private EditText addStaffEdtx;
    private TextView saveStaffTxt;
    private TextView saveTxt;

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Inject
    @InjectPresenter
    HomePresenter presenter;
    private StartActivity startAuthActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof NavigationActivity) {
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
        presenter.setRouter(localCiceroneHolder.getCicerone("Home").getRouter());
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        nameEdtx = view.findViewById(R.id.home_name);
        phoneEdtx = view.findViewById(R.id.home_phone);
        emailEdtx = view.findViewById(R.id.home_email);
        addressEdtx = view.findViewById(R.id.home_address);
        changeUserBtn = view.findViewById(R.id.change_user);
        editTxt = view.findViewById(R.id.edit_user);
        saveTxt = view.findViewById(R.id.save_user);
        busEdtx = view.findViewById(R.id.home_bus);
        addStaffTxt = view.findViewById(R.id.add_new_staff);
        addStaffEdtx = view.findViewById(R.id.new_staff_edtx);
        saveStaffTxt = view.findViewById(R.id.save_new_staff);

        busEdtx.setOnClickListener(v -> {
            presenter.busFragment();
        });

        editTxt.setOnClickListener(v -> {
            presenter.pressEditUser(true);
        });

        saveTxt.setOnClickListener(v -> {
            presenter.pressEditUser(false);
            User user = new User();
            user.setName(nameEdtx.getText().toString());
            user.setPhone(phoneEdtx.getText().toString());
            user.setEmail(emailEdtx.getText().toString());
            user.setAddress(addressEdtx.getText().toString());
            presenter.updateUser(user);
        });

        changeUserBtn.setOnClickListener(view1 -> {
            presenter.signOut();
        });

        addStaffTxt.setOnClickListener(v ->{
            presenter.onAddStaffClicked();
        });

        saveStaffTxt.setOnClickListener(v -> {
            presenter.onSaveStaffClicked(addStaffEdtx.getText().toString());
        });
    }

    @ProvidePresenter
    HomePresenter provideHomePresenter() {
        return presenter;
    }

    @Override
    public void setField(User user) {
        nameEdtx.setText(user.getName());
        phoneEdtx.setText(user.getPhone());
        emailEdtx.setText(user.getEmail());
        if (user.getDriver()) {
            addressEdtx.setText(user.getAddress());
        }
    }

    @Override
    public void setFiledBus(BusDto bus) {
        busEdtx.setText(bus.getBusmodel());
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

    @Override
    public void setVisibility(Boolean isDriver) {
        if (isDriver) {
            busEdtx.setVisibility(View.VISIBLE);
            addressEdtx.setVisibility(View.VISIBLE);
            addStaffTxt.setVisibility(View.VISIBLE);
        } else {
            busEdtx.setVisibility(View.GONE);
            addressEdtx.setVisibility(View.GONE);
            addStaffTxt.setVisibility(View.GONE);
        }
    }

    @Override
    public void setVisibilityNewStaff(Boolean visibility) {
        if (visibility){
            addStaffTxt.setVisibility(View.GONE);
            saveStaffTxt.setVisibility(View.VISIBLE);
            addStaffEdtx.setVisibility(View.VISIBLE);
        } else {
            addStaffTxt.setVisibility(View.VISIBLE);
            saveStaffTxt.setVisibility(View.GONE);
            addStaffEdtx.setVisibility(View.GONE);
        }
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    public static HomeFragment newInstance() {
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

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
