package com.clabuyakchai.staff.di.module;

import android.content.Context;

import com.clabuyakchai.staff.data.local.AppDatabase;
import com.clabuyakchai.staff.di.scope.ApplicationScope;

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
