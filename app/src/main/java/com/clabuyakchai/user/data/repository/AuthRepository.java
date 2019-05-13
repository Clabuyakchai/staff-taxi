package com.clabuyakchai.user.data.repository;

import com.clabuyakchai.user.data.remote.request.LocalDto;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import okhttp3.ResponseBody;

public interface AuthRepository {
    void startVerification(String phone);
    Boolean isUserSignedIn();
    void signOut();
    PublishSubject<Boolean> verifyWithCode(String code);
    Single<ResponseBody> signIn(String phone);
    Single<ResponseBody> signUp(LocalDto localDto);
}
