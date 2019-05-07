package com.clabuyakchai.staff.ui.fragment.auth.registration;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.util.Preferences;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RegistrationFragment extends BaseFragment implements RegistrationView {
    private EditText staffName;
    private EditText staffPhone;
    private EditText staffEmail;
    private EditText staffGender;
    private EditText staffAddress;
    private Button signUp;

    @Inject
    @InjectPresenter
    RegistrationPresenter presenter;
    private StartActivity startNavActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AuthActivity){
            startNavActivity = (AuthActivity)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();

        staffName = view.findViewById(R.id.name);
        staffPhone = view.findViewById(R.id.phone);
        staffEmail = view.findViewById(R.id.email);
        staffGender = view.findViewById(R.id.gender);
        staffAddress = view.findViewById(R.id.address);

        signUp = view.findViewById(R.id.sign_up);
        signUp.setOnClickListener(v -> {
            StaffDto staff = new StaffDto(1L,
                    staffPhone.getText().toString().substring(1),
                    staffEmail.getText().toString(),
                    staffGender.getText().toString(),
                    staffName.getText().toString(),
                    staffAddress.getText().toString());

            presenter.signUp(staff);
        });
    }

    @ProvidePresenter
    RegistrationPresenter provideRegistrationPresenter(){
        return presenter;
    }

    @Override
    public void addToken(String token) {
        Preferences.setTokenSharedPreferences(getContext(), token);
    }

    @Override
    public void navActivity() {
        startNavActivity.startActivity();
    }

    public static RegistrationFragment newInstance(){
        return new RegistrationFragment();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        startNavActivity = null;
        super.onDetach();
    }
}
