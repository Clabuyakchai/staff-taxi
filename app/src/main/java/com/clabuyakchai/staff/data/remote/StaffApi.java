package com.clabuyakchai.staff.data.remote;

import com.clabuyakchai.staff.data.remote.request.StaffDto;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface StaffApi {
    @GET("/staff/signin")
    Single<ResponseBody> signIn(@Query("phone") String phone);

    @POST("/staff/signup")
    Single<ResponseBody> signUp(@Body StaffDto staffDto);
}
