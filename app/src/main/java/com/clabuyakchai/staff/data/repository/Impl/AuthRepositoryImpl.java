package com.clabuyakchai.staff.data.repository.Impl;

import android.util.Log;

import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import okhttp3.ResponseBody;

public class AuthRepositoryImpl implements AuthRepository {
    private final FirebaseAuth auth;
    private final PhoneAuthProvider provider;
    private final StaffApi staffApi;
    private String storedVerificationId;
    private PhoneAuthProvider.ForceResendingToken resendToken;

    @Inject
    public AuthRepositoryImpl(FirebaseAuth auth, PhoneAuthProvider provider, StaffApi staffApi) {
        this.auth = auth;
        this.provider = provider;
        this.staffApi = staffApi;
    }

    @Override
    public void startVerification(String phone) {
        provider.verifyPhoneNumber(phone,
                60L,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                callbacks);
    }

    @Override
    public Boolean isUserSignedIn() {
        return auth.getCurrentUser() != null;
    }

    @Override
    public void signOut() {
        auth.signOut();
    }

    @Override
    public PublishSubject<Boolean> verifyWithCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(storedVerificationId, code);
        return signInWithPhoneAuthCredential(credential);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential credential) {
            Log.d("TAG", "onVerificationCompleted:" + credential);

            signInWithPhoneAuthCredential(credential);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w("TAG", "onVerificationFailed", e);

            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                // Invalid request
                // ...
            } else if (e instanceof FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
                // ...
            }

            // Show a message and update the UI
            // ...
        }

        @Override
        public void onCodeSent(String verificationId,
                               PhoneAuthProvider.ForceResendingToken token) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d("TAG", "onCodeSent:" + verificationId);

            // Save verification ID and resending token so we can use them later
            storedVerificationId = verificationId;
            resendToken = token;

        }
    };

    private PublishSubject<Boolean> signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        PublishSubject<Boolean> subject = PublishSubject.create();
        auth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        subject.onNext(true);
                    } else {
                        subject.onNext(false);
                    }
                    subject.onComplete();
                });

        return subject;
    }

    @Override
    public Single<ResponseBody> signIn(String phone) {
        return staffApi.signIn(phone);
    }

    @Override
    public Single<ResponseBody> signUp(StaffDto staffDto) {
        return staffApi.signUp(staffDto);
    }
}
