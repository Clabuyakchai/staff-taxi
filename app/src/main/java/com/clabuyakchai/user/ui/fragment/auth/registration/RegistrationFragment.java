package com.clabuyakchai.user.ui.fragment.auth.registration;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.util.Preferences;
import com.clabuyakchai.user.R;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RegistrationFragment extends BaseFragment implements RegistrationView {
    private static final String ARG_PHONE = "phone_key";
    private EditText staffName;
    private EditText staffPhone;
    private EditText staffEmail;
    private RadioGroup staffGender;
    private Button signUp;
    private String gender = "male";

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
        return inflater.inflate(R.layout.auth_registration_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();

        staffName = view.findViewById(R.id.name);
        staffPhone = view.findViewById(R.id.phone);
        staffEmail = view.findViewById(R.id.email);
        staffGender = view.findViewById(R.id.gender);

        staffPhone.setText(getArguments().getString(ARG_PHONE));

        staffGender.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (radioGroup.getId()){
                case R.id.male:
                    gender = getString(R.string.male);
                    break;
                case R.id.female:
                    gender = getString(R.string.female);
                    break;
                default:
                    gender = getString(R.string.male);
                    break;
            }
        });

        signUp = view.findViewById(R.id.sign_up);
        signUp.setOnClickListener(v -> {
            LocalDto staff = new LocalDto(1L,
                    staffPhone.getText().toString(),
                    staffEmail.getText().toString(),
                    gender,
                    staffName.getText().toString());

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

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    public static RegistrationFragment newInstance(String phone){
        Bundle args = new Bundle();
        args.putString(ARG_PHONE, phone);

        RegistrationFragment fragment = new RegistrationFragment();
        fragment.setArguments(args);

        return fragment;
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
