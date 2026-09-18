package com.emojimaker.horor.emoji.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteStatement;
import com.emojimaker.horor.emoji.data.local.entity.JsonCacheEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class JsonCacheDao_Impl implements JsonCacheDao {
  private final RoomDatabase __db;

  private final EntityUpsertAdapter<JsonCacheEntity> __upsertAdapterOfJsonCacheEntity;

  public JsonCacheDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertAdapterOfJsonCacheEntity = new EntityUpsertAdapter<JsonCacheEntity>(new EntityInsertAdapter<JsonCacheEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `json_cache` (`key`,`json`,`updatedAt`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final JsonCacheEntity entity) {
        if (entity.getKey() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getKey());
        }
        if (entity.getJson() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getJson());
        }
        statement.bindLong(3, entity.getUpdatedAt());
      }
    }, new EntityDeleteOrUpdateAdapter<JsonCacheEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `json_cache` SET `key` = ?,`json` = ?,`updatedAt` = ? WHERE `key` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final JsonCacheEntity entity) {
        if (entity.getKey() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getKey());
        }
        if (entity.getJson() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getJson());
        }
        statement.bindLong(3, entity.getUpdatedAt());
        if (entity.getKey() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getKey());
        }
      }
    });
  }

  @Override
  public Object upsert(final JsonCacheEntity cache, final Continuation<? super Unit> $completion) {
    if (cache == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __upsertAdapterOfJsonCacheEntity.upsert(_connection, cache);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getJson(final String key, final Continuation<? super String> $completion) {
    final String _sql = "SELECT json FROM json_cache WHERE `key` = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (key == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, key);
        }
        final String _result;
        if (_stmt.step()) {
          if (_stmt.isNull(0)) {
            _result = null;
          } else {
            _result = _stmt.getText(0);
          }
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getJsonLength(final String key, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT length(json) FROM json_cache WHERE `key` = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (key == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, key);
        }
        final Integer _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getJsonChunk(final String key, final int start, final int length,
      final Continuation<? super String> $completion) {
    final String _sql = "SELECT substr(json, ?, ?) FROM json_cache WHERE `key` = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, start);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, length);
        _argIndex = 3;
        if (key == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, key);
        }
        final String _result;
        if (_stmt.step()) {
          final String _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = _stmt.getText(0);
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object countKey(final String key, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM json_cache WHERE `key` = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (key == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, key);
        }
        final Integer _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteByKey(final String key, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM json_cache WHERE `key` = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (key == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, key);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
