package com.clabuyakchai.staff.ui.fragment.auth.phone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.base.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthPhoneFragment extends BaseFragment implements AuthPhoneView {

    private EditText phone;
    private Button sendPhone;

    @Inject
    @InjectPresenter
    AuthPhonePresenterImpl presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.auth_phone_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        phone = view.findViewById(R.id.phone_number);
        sendPhone = view.findViewById(R.id.send_phone);
        sendPhone.setOnClickListener(view1 -> {
            presenter.sendVerificationPhone(phone.getText().toString());
        });
    }

//    @ProvidePresenter
//    CurrencyPresenterImpl providePresenter() {
//        return presenter;
//    }

    public static AuthPhoneFragment newInstance() {
        return new AuthPhoneFragment();
    }
}
