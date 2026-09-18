package com.emojimaker.horor.emoji.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteStatement;
import com.emojimaker.horor.emoji.data.local.entity.AppSettingEntity;
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
public final class AppSettingDao_Impl implements AppSettingDao {
  private final RoomDatabase __db;

  private final EntityUpsertAdapter<AppSettingEntity> __upsertAdapterOfAppSettingEntity;

  public AppSettingDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertAdapterOfAppSettingEntity = new EntityUpsertAdapter<AppSettingEntity>(new EntityInsertAdapter<AppSettingEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `app_settings` (`key`,`value`,`updatedAt`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final AppSettingEntity entity) {
        if (entity.getKey() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getKey());
        }
        if (entity.getValue() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getValue());
        }
        statement.bindLong(3, entity.getUpdatedAt());
      }
    }, new EntityDeleteOrUpdateAdapter<AppSettingEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `app_settings` SET `key` = ?,`value` = ?,`updatedAt` = ? WHERE `key` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final AppSettingEntity entity) {
        if (entity.getKey() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getKey());
        }
        if (entity.getValue() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getValue());
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
  public Object upsert(final AppSettingEntity setting, final Continuation<? super Unit> arg1) {
    if (setting == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __upsertAdapterOfAppSettingEntity.upsert(_connection, setting);
      return Unit.INSTANCE;
    }, arg1);
  }

  @Override
  public Object getValue(final String key, final Continuation<? super String> arg1) {
    final String _sql = "SELECT value FROM app_settings WHERE `key` = ? LIMIT 1";
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
    }, arg1);
  }

  @Override
  public Object count(final Continuation<? super Integer> arg0) {
    final String _sql = "SELECT COUNT(*) FROM app_settings";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
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
    }, arg0);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
