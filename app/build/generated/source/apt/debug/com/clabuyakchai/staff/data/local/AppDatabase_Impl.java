package com.clabuyakchai.staff.data.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.clabuyakchai.staff.data.local.dao.StaffDao;
import com.clabuyakchai.staff.data.local.dao.StaffDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile StaffDao _staffDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `staff` (`staffID` INTEGER, `phone` TEXT, `email` TEXT, `gender` TEXT, `name` TEXT, `address` TEXT, PRIMARY KEY(`staffID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"1bcf4d2deeaac1b149f610e4a15af2aa\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `staff`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsStaff = new HashMap<String, TableInfo.Column>(6);
        _columnsStaff.put("staffID", new TableInfo.Column("staffID", "INTEGER", false, 1));
        _columnsStaff.put("phone", new TableInfo.Column("phone", "TEXT", false, 0));
        _columnsStaff.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsStaff.put("gender", new TableInfo.Column("gender", "TEXT", false, 0));
        _columnsStaff.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsStaff.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStaff = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStaff = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStaff = new TableInfo("staff", _columnsStaff, _foreignKeysStaff, _indicesStaff);
        final TableInfo _existingStaff = TableInfo.read(_db, "staff");
        if (! _infoStaff.equals(_existingStaff)) {
          throw new IllegalStateException("Migration didn't properly handle staff(com.clabuyakchai.staff.data.local.entity.Staff).\n"
                  + " Expected:\n" + _infoStaff + "\n"
                  + " Found:\n" + _existingStaff);
        }
      }
    }, "1bcf4d2deeaac1b149f610e4a15af2aa", "a291c397c82eda136ee468f24cf2a9c9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "staff");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `staff`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public StaffDao staffDao() {
    if (_staffDao != null) {
      return _staffDao;
    } else {
      synchronized(this) {
        if(_staffDao == null) {
          _staffDao = new StaffDao_Impl(this);
        }
        return _staffDao;
      }
    }
  }
}
