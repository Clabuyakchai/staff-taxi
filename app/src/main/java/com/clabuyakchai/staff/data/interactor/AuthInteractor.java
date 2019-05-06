package com.clabuyakchai.staff.data.interactor;

public interface AuthInteractor {
    void startVerification(String phone);
    Boolean isUserSignedIn();
    void signOut();
    void verifyWithCode(String code);
}
