package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.di.scope.ApplicationScope;
import com.clabuyakchai.staff.util.MyServiceInterceptor;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteModule {

    @ApplicationScope
    @Provides
    public StaffApi provideStaffApi(Retrofit retrofit){
        return retrofit.create(StaffApi.class);
    }

    @ApplicationScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.100.8:8090/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
    }

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttpClient(MyServiceInterceptor myServiceInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(myServiceInterceptor)
                .build();
    }
}
