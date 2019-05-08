package com.clabuyakchai.staff.data.local.dao;

import com.clabuyakchai.staff.data.local.entity.Staff;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface StaffDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Staff staff);

    @Query("DELETE FROM staff")
    void delete();

    @Query("select * from staff")
    Single<List<Staff>> getStaff();
}
