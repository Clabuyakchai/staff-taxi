package com.clabuyakchai.user.di.module;

import android.content.Context;

import com.clabuyakchai.user.data.local.AppDatabase;
import com.clabuyakchai.user.di.scope.ApplicationScope;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @ApplicationScope
    @Provides
    public AppDatabase provideAppDatabase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "db").build();
    }
}
