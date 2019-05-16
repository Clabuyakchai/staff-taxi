package com.clabuyakchai.user.ui.fragment.auth.phone;

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
import com.clabuyakchai.user.ui.activity.FragmentStack;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.auth.code.AuthCodeFragment;
import com.clabuyakchai.user.util.Preferences;
import com.clabuyakchai.user.R;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AuthPhoneFragment extends BaseFragment implements AuthPhoneView {
    private static final String TITLE = "Phone";

    private EditText phone;
    private Button sendPhone;
    private Toolbar toolbar;
    private TextView toolbarTitle;

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
//
//        toolbar = view.findViewById(R.id.toolbar);
//        toolbarTitle = view.findViewById(R.id.toolbar_title);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

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
    public void codeFragment(String phone) {
        fragmentStack.add(AuthCodeFragment.newInstance(phone), false);
    }

    @Override
    public void navActivity() {
        startNavActivity.startActivity();
    }

    @Override
    public void getToken() {
        presenter.isVerify(Preferences.getTokenSharedPreferences(getContext()));
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
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
