package com.clabuyakchai.staff.data.interactor.Impl;

import com.clabuyakchai.staff.data.interactor.AuthInteractor;
import com.clabuyakchai.staff.data.repository.AuthRepository;

import javax.inject.Inject;

public class AuthInteractorImpl implements AuthInteractor {
    private final AuthRepository authRepository;

    @Inject
    public AuthInteractorImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void startVerification(String phone) {
        authRepository.startVerification(phone);
    }

    @Override
    public Boolean isUserSignedIn() {
        return authRepository.isUserSignedIn();
    }

    @Override
    public void signOut() {
        authRepository.signOut();
    }

    @Override
    public void verifyWithCode(String code) {
        authRepository.verifyWithCode(code);
    }
}
