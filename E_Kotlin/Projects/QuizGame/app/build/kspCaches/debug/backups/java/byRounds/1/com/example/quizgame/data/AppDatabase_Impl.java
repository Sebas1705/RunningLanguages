package com.example.quizgame.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.quizgame.data.dao.PlayerDao;
import com.example.quizgame.data.dao.PlayerDao_Impl;
import com.example.quizgame.data.dao.QFromImageDao;
import com.example.quizgame.data.dao.QFromImageDao_Impl;
import com.example.quizgame.data.dao.QImageDao;
import com.example.quizgame.data.dao.QImageDao_Impl;
import com.example.quizgame.data.dao.QTextDao;
import com.example.quizgame.data.dao.QTextDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PlayerDao _playerDao;

  private volatile QFromImageDao _qFromImageDao;

  private volatile QImageDao _qImageDao;

  private volatile QTextDao _qTextDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `players_table` (`name` TEXT NOT NULL, `score` INTEGER NOT NULL, PRIMARY KEY(`name`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `qFromImage_table` (`question` TEXT NOT NULL, `image` INTEGER, `correctAnswer` INTEGER NOT NULL, `answers` TEXT NOT NULL, `type` TEXT NOT NULL, PRIMARY KEY(`question`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `qImage_table` (`question` TEXT NOT NULL, `correctAnswer` INTEGER NOT NULL, `answers` TEXT NOT NULL, `type` TEXT NOT NULL, `image` INTEGER, PRIMARY KEY(`question`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `qText_table` (`question` TEXT NOT NULL, `correctAnswer` INTEGER NOT NULL, `answers` TEXT NOT NULL, `type` TEXT NOT NULL, `image` INTEGER, PRIMARY KEY(`question`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8e73434512021fd7ee7979d3e6610ebe')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `players_table`");
        db.execSQL("DROP TABLE IF EXISTS `qFromImage_table`");
        db.execSQL("DROP TABLE IF EXISTS `qImage_table`");
        db.execSQL("DROP TABLE IF EXISTS `qText_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsPlayersTable = new HashMap<String, TableInfo.Column>(2);
        _columnsPlayersTable.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayersTable.put("score", new TableInfo.Column("score", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlayersTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlayersTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlayersTable = new TableInfo("players_table", _columnsPlayersTable, _foreignKeysPlayersTable, _indicesPlayersTable);
        final TableInfo _existingPlayersTable = TableInfo.read(db, "players_table");
        if (!_infoPlayersTable.equals(_existingPlayersTable)) {
          return new RoomOpenHelper.ValidationResult(false, "players_table(com.example.quizgame.data.entities.PlayerEntity).\n"
                  + " Expected:\n" + _infoPlayersTable + "\n"
                  + " Found:\n" + _existingPlayersTable);
        }
        final HashMap<String, TableInfo.Column> _columnsQFromImageTable = new HashMap<String, TableInfo.Column>(5);
        _columnsQFromImageTable.put("question", new TableInfo.Column("question", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQFromImageTable.put("image", new TableInfo.Column("image", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQFromImageTable.put("correctAnswer", new TableInfo.Column("correctAnswer", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQFromImageTable.put("answers", new TableInfo.Column("answers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQFromImageTable.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQFromImageTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQFromImageTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQFromImageTable = new TableInfo("qFromImage_table", _columnsQFromImageTable, _foreignKeysQFromImageTable, _indicesQFromImageTable);
        final TableInfo _existingQFromImageTable = TableInfo.read(db, "qFromImage_table");
        if (!_infoQFromImageTable.equals(_existingQFromImageTable)) {
          return new RoomOpenHelper.ValidationResult(false, "qFromImage_table(com.example.quizgame.data.entities.QFromImageEntity).\n"
                  + " Expected:\n" + _infoQFromImageTable + "\n"
                  + " Found:\n" + _existingQFromImageTable);
        }
        final HashMap<String, TableInfo.Column> _columnsQImageTable = new HashMap<String, TableInfo.Column>(5);
        _columnsQImageTable.put("question", new TableInfo.Column("question", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQImageTable.put("correctAnswer", new TableInfo.Column("correctAnswer", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQImageTable.put("answers", new TableInfo.Column("answers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQImageTable.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQImageTable.put("image", new TableInfo.Column("image", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQImageTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQImageTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQImageTable = new TableInfo("qImage_table", _columnsQImageTable, _foreignKeysQImageTable, _indicesQImageTable);
        final TableInfo _existingQImageTable = TableInfo.read(db, "qImage_table");
        if (!_infoQImageTable.equals(_existingQImageTable)) {
          return new RoomOpenHelper.ValidationResult(false, "qImage_table(com.example.quizgame.data.entities.QImageEntity).\n"
                  + " Expected:\n" + _infoQImageTable + "\n"
                  + " Found:\n" + _existingQImageTable);
        }
        final HashMap<String, TableInfo.Column> _columnsQTextTable = new HashMap<String, TableInfo.Column>(5);
        _columnsQTextTable.put("question", new TableInfo.Column("question", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQTextTable.put("correctAnswer", new TableInfo.Column("correctAnswer", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQTextTable.put("answers", new TableInfo.Column("answers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQTextTable.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQTextTable.put("image", new TableInfo.Column("image", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQTextTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQTextTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQTextTable = new TableInfo("qText_table", _columnsQTextTable, _foreignKeysQTextTable, _indicesQTextTable);
        final TableInfo _existingQTextTable = TableInfo.read(db, "qText_table");
        if (!_infoQTextTable.equals(_existingQTextTable)) {
          return new RoomOpenHelper.ValidationResult(false, "qText_table(com.example.quizgame.data.entities.QTextEntity).\n"
                  + " Expected:\n" + _infoQTextTable + "\n"
                  + " Found:\n" + _existingQTextTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8e73434512021fd7ee7979d3e6610ebe", "f4b24dade1bf663641a849d1d2773ffa");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "players_table","qFromImage_table","qImage_table","qText_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `players_table`");
      _db.execSQL("DELETE FROM `qFromImage_table`");
      _db.execSQL("DELETE FROM `qImage_table`");
      _db.execSQL("DELETE FROM `qText_table`");
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
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PlayerDao.class, PlayerDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(QFromImageDao.class, QFromImageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(QImageDao.class, QImageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(QTextDao.class, QTextDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PlayerDao playerDao() {
    if (_playerDao != null) {
      return _playerDao;
    } else {
      synchronized(this) {
        if(_playerDao == null) {
          _playerDao = new PlayerDao_Impl(this);
        }
        return _playerDao;
      }
    }
  }

  @Override
  public QFromImageDao qFromImageDao() {
    if (_qFromImageDao != null) {
      return _qFromImageDao;
    } else {
      synchronized(this) {
        if(_qFromImageDao == null) {
          _qFromImageDao = new QFromImageDao_Impl(this);
        }
        return _qFromImageDao;
      }
    }
  }

  @Override
  public QImageDao qImageDao() {
    if (_qImageDao != null) {
      return _qImageDao;
    } else {
      synchronized(this) {
        if(_qImageDao == null) {
          _qImageDao = new QImageDao_Impl(this);
        }
        return _qImageDao;
      }
    }
  }

  @Override
  public QTextDao qTextDao() {
    if (_qTextDao != null) {
      return _qTextDao;
    } else {
      synchronized(this) {
        if(_qTextDao == null) {
          _qTextDao = new QTextDao_Impl(this);
        }
        return _qTextDao;
      }
    }
  }
}
