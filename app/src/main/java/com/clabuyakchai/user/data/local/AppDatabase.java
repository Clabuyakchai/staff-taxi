package com.clabuyakchai.user.data.local;

import com.clabuyakchai.user.data.local.dao.UserDao;
import com.clabuyakchai.user.data.local.entity.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
