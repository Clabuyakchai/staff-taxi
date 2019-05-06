package com.clabuyakchai.staff.ui.fragment.auth.code;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AuthCodeFragment extends BaseFragment {
    private static final String KEY_VERIFICATION_CODE = "Verification_Code";
    private EditText verificationCodeEdt;
    private FirebaseAuth auth;
    private String verificationId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verificationId = savedInstanceState.getString(KEY_VERIFICATION_CODE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.auth_code_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        verificationCodeEdt = view.findViewById(R.id.verification_code);
        verificationCodeEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
//                if(count == 6){
//                    String code = verificationCodeEdt.getText().toString();
//                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//                    signInWithPhoneAuthCredential(credential);
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



    public static AuthCodeFragment newInstance(String verCode){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_VERIFICATION_CODE, verCode);

        AuthCodeFragment fragment = new AuthCodeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
