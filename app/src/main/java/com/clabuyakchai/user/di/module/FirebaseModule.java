package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.di.scope.ApplicationScope;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {
    @ApplicationScope
    @Provides
    public FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    @ApplicationScope
    @Provides
    public PhoneAuthProvider providePhoneAuthProvider(){
        return PhoneAuthProvider.getInstance();
    }
}
