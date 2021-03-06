package com.clabuyakchai.user.util;

import android.content.Context;

import com.clabuyakchai.user.di.scope.ApplicationScope;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@ApplicationScope
public class MyServiceInterceptor implements Interceptor {
    private String sessionToken;

    private final Context context;

    @Inject
    public MyServiceInterceptor(Context context) {
        this.context = context;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder requestBuilder = request.newBuilder();

        sessionToken = Preferences.getTokenSharedPreferences(context);

        if (sessionToken != null) {
            requestBuilder.addHeader("Authorization", "Bearer " + sessionToken);
        } else {
            requestBuilder.removeHeader("Authorization");
        }

        return chain.proceed(requestBuilder.build());
    }
}
