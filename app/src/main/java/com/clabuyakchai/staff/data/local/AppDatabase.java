package com.clabuyakchai.staff.data.local;

import com.clabuyakchai.staff.data.local.dao.StaffDao;
import com.clabuyakchai.staff.data.local.entity.Staff;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Staff.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StaffDao staffDao();
}
