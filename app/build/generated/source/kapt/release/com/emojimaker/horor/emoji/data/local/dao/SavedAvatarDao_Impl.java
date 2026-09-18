package com.emojimaker.horor.emoji.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteStatement;
import com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class SavedAvatarDao_Impl implements SavedAvatarDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<SavedAvatarEntity> __insertAdapterOfSavedAvatarEntity;

  private final EntityUpsertAdapter<SavedAvatarEntity> __upsertAdapterOfSavedAvatarEntity;

  public SavedAvatarDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfSavedAvatarEntity = new EntityInsertAdapter<SavedAvatarEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `saved_avatars` (`id`,`avatarPath`,`pathInternalEdit`,`suggestionJson`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final SavedAvatarEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getAvatarPath() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getAvatarPath());
        }
        if (entity.getPathInternalEdit() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getPathInternalEdit());
        }
        if (entity.getSuggestionJson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getSuggestionJson());
        }
        statement.bindLong(5, entity.getCreatedAt());
        statement.bindLong(6, entity.getUpdatedAt());
      }
    };
    this.__upsertAdapterOfSavedAvatarEntity = new EntityUpsertAdapter<SavedAvatarEntity>(new EntityInsertAdapter<SavedAvatarEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `saved_avatars` (`id`,`avatarPath`,`pathInternalEdit`,`suggestionJson`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final SavedAvatarEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getAvatarPath() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getAvatarPath());
        }
        if (entity.getPathInternalEdit() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getPathInternalEdit());
        }
        if (entity.getSuggestionJson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getSuggestionJson());
        }
        statement.bindLong(5, entity.getCreatedAt());
        statement.bindLong(6, entity.getUpdatedAt());
      }
    }, new EntityDeleteOrUpdateAdapter<SavedAvatarEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `saved_avatars` SET `id` = ?,`avatarPath` = ?,`pathInternalEdit` = ?,`suggestionJson` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final SavedAvatarEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getAvatarPath() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getAvatarPath());
        }
        if (entity.getPathInternalEdit() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getPathInternalEdit());
        }
        if (entity.getSuggestionJson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getSuggestionJson());
        }
        statement.bindLong(5, entity.getCreatedAt());
        statement.bindLong(6, entity.getUpdatedAt());
        statement.bindLong(7, entity.getId());
      }
    });
  }

  @Override
  public Object insertAll(final List<SavedAvatarEntity> items,
      final Continuation<? super Unit> arg1) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfSavedAvatarEntity.insert(_connection, items);
      return Unit.INSTANCE;
    }, arg1);
  }

  @Override
  public Object replaceAll(final List<SavedAvatarEntity> items,
      final Continuation<? super Unit> $completion) {
    return DBUtil.performInTransactionSuspending(__db, (_cont) -> {
      return SavedAvatarDao.super.replaceAll(items, _cont);
    }, $completion);
  }

  @Override
  public Object upsert(final SavedAvatarEntity item, final Continuation<? super Unit> arg1) {
    if (item == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __upsertAdapterOfSavedAvatarEntity.upsert(_connection, item);
      return Unit.INSTANCE;
    }, arg1);
  }

  @Override
  public Object getAll(final Continuation<? super List<SavedAvatarEntity>> arg0) {
    final String _sql = "SELECT * FROM saved_avatars ORDER BY createdAt DESC, id DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAvatarPath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "avatarPath");
        final int _columnIndexOfPathInternalEdit = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pathInternalEdit");
        final int _columnIndexOfSuggestionJson = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "suggestionJson");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
        final List<SavedAvatarEntity> _result = new ArrayList<SavedAvatarEntity>();
        while (_stmt.step()) {
          final SavedAvatarEntity _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpAvatarPath;
          if (_stmt.isNull(_columnIndexOfAvatarPath)) {
            _tmpAvatarPath = null;
          } else {
            _tmpAvatarPath = _stmt.getText(_columnIndexOfAvatarPath);
          }
          final String _tmpPathInternalEdit;
          if (_stmt.isNull(_columnIndexOfPathInternalEdit)) {
            _tmpPathInternalEdit = null;
          } else {
            _tmpPathInternalEdit = _stmt.getText(_columnIndexOfPathInternalEdit);
          }
          final String _tmpSuggestionJson;
          if (_stmt.isNull(_columnIndexOfSuggestionJson)) {
            _tmpSuggestionJson = null;
          } else {
            _tmpSuggestionJson = _stmt.getText(_columnIndexOfSuggestionJson);
          }
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          final long _tmpUpdatedAt;
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
          _item = new SavedAvatarEntity(_tmpId,_tmpAvatarPath,_tmpPathInternalEdit,_tmpSuggestionJson,_tmpCreatedAt,_tmpUpdatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, arg0);
  }

  @Override
  public Object count(final Continuation<? super Integer> arg0) {
    final String _sql = "SELECT COUNT(*) FROM saved_avatars";
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

  @Override
  public Object getByPath(final String path, final Continuation<? super SavedAvatarEntity> arg1) {
    final String _sql = "SELECT * FROM saved_avatars WHERE pathInternalEdit = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (path == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, path);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAvatarPath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "avatarPath");
        final int _columnIndexOfPathInternalEdit = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pathInternalEdit");
        final int _columnIndexOfSuggestionJson = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "suggestionJson");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
        final SavedAvatarEntity _result;
        if (_stmt.step()) {
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpAvatarPath;
          if (_stmt.isNull(_columnIndexOfAvatarPath)) {
            _tmpAvatarPath = null;
          } else {
            _tmpAvatarPath = _stmt.getText(_columnIndexOfAvatarPath);
          }
          final String _tmpPathInternalEdit;
          if (_stmt.isNull(_columnIndexOfPathInternalEdit)) {
            _tmpPathInternalEdit = null;
          } else {
            _tmpPathInternalEdit = _stmt.getText(_columnIndexOfPathInternalEdit);
          }
          final String _tmpSuggestionJson;
          if (_stmt.isNull(_columnIndexOfSuggestionJson)) {
            _tmpSuggestionJson = null;
          } else {
            _tmpSuggestionJson = _stmt.getText(_columnIndexOfSuggestionJson);
          }
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          final long _tmpUpdatedAt;
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
          _result = new SavedAvatarEntity(_tmpId,_tmpAvatarPath,_tmpPathInternalEdit,_tmpSuggestionJson,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object clear(final Continuation<? super Unit> arg0) {
    final String _sql = "DELETE FROM saved_avatars";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, arg0);
  }

  @Override
  public Object deleteByPaths(final List<String> paths, final Continuation<? super Integer> arg1) {
    final StringBuilder _stringBuilder = new StringBuilder();
    _stringBuilder.append("DELETE FROM saved_avatars WHERE pathInternalEdit IN (");
    final int _inputSize = paths.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        for (String _item : paths) {
          if (_item == null) {
            _stmt.bindNull(_argIndex);
          } else {
            _stmt.bindText(_argIndex, _item);
          }
          _argIndex++;
        }
        _stmt.step();
        return SQLiteConnectionUtil.getTotalChangedRows(_connection);
      } finally {
        _stmt.close();
      }
    }, arg1);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
