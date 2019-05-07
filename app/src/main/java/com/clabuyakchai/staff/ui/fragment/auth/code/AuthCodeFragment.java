package com.clabuyakchai.staff.ui.fragment.auth.code;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragment;
import com.clabuyakchai.staff.util.Preferences;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthCodeFragment extends BaseFragment implements AuthCodeView {
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
            presenter.verifyCode(verificationCodeEdt.getText().toString(), Preferences.getTokenSharedPreferences(getContext()));
        });
    }

    @ProvidePresenter
    AuthCodePresenter provideAuthCodePresenter(){
        return presenter;
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navActivity() {
        startNavActivity.startActivity();
    }

    @Override
    public void registrationFragment() {
        fragmentStack.add(RegistrationFragment.newInstance(), false);
    }

    public static AuthCodeFragment newInstance(){
        return new AuthCodeFragment();
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
