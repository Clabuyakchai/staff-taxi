package com.clabuyakchai.staff.ui.fragment.auth.phone;

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
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment;
import com.clabuyakchai.staff.util.Preferences;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthPhoneFragment extends BaseFragment implements AuthPhoneView {

    private EditText phone;
    private Button sendPhone;

    @Inject
    @InjectPresenter
    AuthPhonePresenter presenter;
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
        return inflater.inflate(R.layout.auth_phone_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();

        phone = view.findViewById(R.id.phone_number);
        sendPhone = view.findViewById(R.id.send_phone);

        sendPhone.setOnClickListener(v ->{
            if(!phone.getText().toString().isEmpty()) {
                presenter.sendVerificationPhone(phone.getText().toString());
            }
        });
    }

    @ProvidePresenter
    AuthPhonePresenter providePresenter() {
        return presenter;
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void codeFragment() {
        fragmentStack.add(AuthCodeFragment.newInstance(), false);
    }

    @Override
    public void navActivity() {
        startNavActivity.startActivity();
    }

    @Override
    public void addToken(String token) {
        Preferences.setTokenSharedPreferences(getContext(), token);
    }

    public static AuthPhoneFragment newInstance() {
        return new AuthPhoneFragment();
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
