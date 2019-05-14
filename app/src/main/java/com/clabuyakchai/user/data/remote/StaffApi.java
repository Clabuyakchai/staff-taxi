package com.clabuyakchai.user.data.remote;

import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.data.remote.request.StaffDto;
import com.clabuyakchai.user.data.remote.request.StationDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StaffApi {
    @GET("/staff/signin")
    Single<ResponseBody> signIn(@Query("phone") String phone);

    @GET("/staff/me")
    Single<StaffDto> getStaff();

    @POST("/staff/update")
    Single<StaffDto> updateStaff(@Body StaffDto staffDto);

    @POST("/local/update")
    Single<LocalDto> updateLocal(@Body LocalDto localDto);

    @GET("/route/staffby")
    Single<List<RouteDto>> findRouteByStaff(@Query("datetime") String datetime, @Query("name") String name);

    @POST("/local/signup")
    Single<ResponseBody> signUp(@Body LocalDto localDto);

    @GET("/local/localbytimetable")
    Single<List<LocalDto>> findLocalByRouteId(@Query("timetableID") Long timetableID);

    @POST("/station/add")
    Single<StationDto> addStation(@Body StationDto stationDto);

    @GET("/station/{city}")
    Single<List<StationDto>> getAllStationByCity(@Path("city") String city);

    @GET("/station/all")
    Single<List<StationDto>> getAllStation();

    @GET("/bus/id")
    Single<BusDto> findBusByStaffId(@Query("staffID") Long staffID);

    @GET("/bus/all")
    Single<List<BusDto>> findAllBus();

    @POST("/bus/add")
    Single<BusDto> addBus(@Body BusDto busDto);

    @GET("/staff/drivebus")
    Completable driveBus(@Query("staffID") Long staffID, @Query("busID") Long busID);

    @POST("/route/create")
    Completable createRoute(@Body RouteDto routeDto);

    @GET(value = "/staff/me")
    Single<StaffDto> whoAmIFromStaff();

    @GET(value = "/local/me")
    Single<LocalDto> whoAmIFromLocal();

    @GET(value = "/staff/becomedriver")
    Completable addStaff(@Query("phone") String phone);

    @GET(value = "/book/booklocal")
    Single<List<BookingDto>> findBookingByLocalIdAndDatetime(@Query("localID") Long localID, @Query("datetime") String datetime);
}
