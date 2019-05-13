package com.clabuyakchai.user.data.local.dao;

import com.clabuyakchai.user.data.local.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM user")
    void delete();

    @Query("select * from user")
    Single<List<User>> getUser();
}
