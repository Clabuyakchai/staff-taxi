package com.clabuyakchai.staff.data.repository;

public interface AuthRepository {
    void startVerification(String phone);
    Boolean isUserSignedIn();
    void signOut();
    void verifyWithCode(String code);
}
