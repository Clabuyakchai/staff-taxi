package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.remote.request.StaffDto;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import okhttp3.ResponseBody;

public interface AuthRepository {
    void startVerification(String phone);
    Boolean isUserSignedIn();
    void signOut();
    PublishSubject<Boolean> verifyWithCode(String code);
    Single<ResponseBody> signIn(String phone);
    Single<ResponseBody> signUp(StaffDto staffDto);
}
