package com.clabuyakchai.user.data.local.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.clabuyakchai.user.data.local.entity.User;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user`(`userID`,`phone`,`email`,`gender`,`name`,`address`,`isDriver`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getUserID());
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
        final Integer _tmp;
        _tmp = value.getDriver() == null ? null : (value.getDriver() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp);
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user";
        return _query;
      }
    };
  }

  @Override
  public void insert(User user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public Single<List<User>> getUser() {
    final String _sql = "select * from user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUserID = _cursor.getColumnIndexOrThrow("userID");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
          final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
          final int _cursorIndexOfIsDriver = _cursor.getColumnIndexOrThrow("isDriver");
          final java.util.List<com.clabuyakchai.user.data.local.entity.User> _result = new java.util.ArrayList<com.clabuyakchai.user.data.local.entity.User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.clabuyakchai.user.data.local.entity.User _item;
            _item = new com.clabuyakchai.user.data.local.entity.User();
            final java.lang.Long _tmpUserID;
            if (_cursor.isNull(_cursorIndexOfUserID)) {
              _tmpUserID = null;
            } else {
              _tmpUserID = _cursor.getLong(_cursorIndexOfUserID);
            }
            _item.setUserID(_tmpUserID);
            final java.lang.String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final java.lang.String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            final java.lang.String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _item.setGender(_tmpGender);
            final java.lang.String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final java.lang.String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _item.setAddress(_tmpAddress);
            final java.lang.Boolean _tmpIsDriver;
            final java.lang.Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsDriver)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsDriver);
            }
            _tmpIsDriver = _tmp == null ? null : _tmp != 0;
            _item.setDriver(_tmpIsDriver);
            _result.add(_item);
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
