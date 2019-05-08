package com.clabuyakchai.staff.data.local.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.clabuyakchai.staff.data.local.entity.Staff;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public final class StaffDao_Impl implements StaffDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfStaff;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStaff;

  public StaffDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStaff = new EntityInsertionAdapter<Staff>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `staff`(`staffID`,`phone`,`email`,`gender`,`name`,`address`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Staff value) {
        if (value.getStaffID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getStaffID());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getGender() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGender());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddress());
        }
      }
    };
    this.__deletionAdapterOfStaff = new EntityDeletionOrUpdateAdapter<Staff>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `staff` WHERE `staffID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Staff value) {
        if (value.getStaffID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getStaffID());
        }
      }
    };
  }

  @Override
  public void insert(Staff staff) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfStaff.insert(staff);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Staff staff) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfStaff.handle(staff);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Single<Staff> getStaff() {
    final String _sql = "select * from staff";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<Staff>() {
      @Override
      public Staff call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfStaffID = _cursor.getColumnIndexOrThrow("staffID");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
          final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
          final com.clabuyakchai.staff.data.local.entity.Staff _result;
          if(_cursor.moveToFirst()) {
            _result = new com.clabuyakchai.staff.data.local.entity.Staff();
            final java.lang.Long _tmpStaffID;
            if (_cursor.isNull(_cursorIndexOfStaffID)) {
              _tmpStaffID = null;
            } else {
              _tmpStaffID = _cursor.getLong(_cursorIndexOfStaffID);
            }
            _result.setStaffID(_tmpStaffID);
            final java.lang.String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _result.setPhone(_tmpPhone);
            final java.lang.String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _result.setEmail(_tmpEmail);
            final java.lang.String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _result.setGender(_tmpGender);
            final java.lang.String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final java.lang.String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _result.setAddress(_tmpAddress);
          } else {
            _result = null;
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
