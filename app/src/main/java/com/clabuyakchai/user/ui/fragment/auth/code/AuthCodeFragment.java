package com.clabuyakchai.user.ui.fragment.auth.code;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.ui.activity.FragmentStack;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.auth.registration.RegistrationFragment;
import com.clabuyakchai.user.util.Preferences;
import com.clabuyakchai.user.R;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthCodeFragment extends BaseFragment implements AuthCodeView {
    private static final String ARG_PHONE = "phone_key";
    private EditText verificationCodeEdt;
    private Button sendCode;

    @Inject
    @InjectPresenter
    AuthCodePresenter presenter;
    @Inject
    FragmentStack fragmentStack;
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
        return inflater.inflate(R.layout.auth_code_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();

        verificationCodeEdt = view.findViewById(R.id.verification_code);
        sendCode = view.findViewById(R.id.send_verify_code);
        sendCode.setOnClickListener(v -> {
            presenter.verifyCode(verificationCodeEdt.getText().toString(), getArguments().getString(ARG_PHONE));
        });
    }

    @ProvidePresenter
    AuthCodePresenter provideAuthCodePresenter(){
        return presenter;
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void navActivity() {
        startNavActivity.startActivity();
    }

    @Override
    public void registrationFragment(String phone) {
        fragmentStack.add(RegistrationFragment.newInstance(phone), false);
    }

    @Override
    public void addToken(String token) {
        Preferences.setTokenSharedPreferences(getContext(), token);
    }

    public static AuthCodeFragment newInstance(String phone){
        Bundle args = new Bundle();
        args.putString(ARG_PHONE, phone);

        AuthCodeFragment fragment = new AuthCodeFragment();
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
