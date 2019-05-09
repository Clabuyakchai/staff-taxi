package com.clabuyakchai.staff.data.remote;

import com.clabuyakchai.staff.data.remote.request.LocalDto;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

import java.util.List;

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

    @GET("/staff/me")
    Single<StaffDto> getStaff();

    @POST("/staff/update")
    Single<StaffDto> updateStaff(@Body StaffDto staffDto);

    @GET("/route/staffby")
    Single<List<RouteDto>> findRouteByStaff(@Query("datetime") String datetime, @Query("name") String name);

    @GET("/local/localbytimetable")
    Single<List<LocalDto>> findLocalByRouteId(@Query("timetableID") Long timetableID);
}
