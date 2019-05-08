package com.clabuyakchai.staff.data.local.dao;

import com.clabuyakchai.staff.data.local.entity.Staff;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface StaffDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Staff staff);

    @Delete
    void delete(Staff staff);

    @Query("select * from staff")
    Single<Staff> getStaff();
}
