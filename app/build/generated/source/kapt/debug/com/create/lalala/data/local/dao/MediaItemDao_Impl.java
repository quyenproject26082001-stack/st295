package com.create.lalala.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteStatement;
import com.create.lalala.data.local.entity.MediaItemEntity;
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
public final class MediaItemDao_Impl implements MediaItemDao {
  private final RoomDatabase __db;

  private final EntityUpsertAdapter<MediaItemEntity> __upsertAdapterOfMediaItemEntity;

  public MediaItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertAdapterOfMediaItemEntity = new EntityUpsertAdapter<MediaItemEntity>(new EntityInsertAdapter<MediaItemEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `media_items` (`path`,`album`,`createdAt`,`updatedAt`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MediaItemEntity entity) {
        if (entity.getPath() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getPath());
        }
        if (entity.getAlbum() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getAlbum());
        }
        statement.bindLong(3, entity.getCreatedAt());
        statement.bindLong(4, entity.getUpdatedAt());
      }
    }, new EntityDeleteOrUpdateAdapter<MediaItemEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `media_items` SET `path` = ?,`album` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `path` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MediaItemEntity entity) {
        if (entity.getPath() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getPath());
        }
        if (entity.getAlbum() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getAlbum());
        }
        statement.bindLong(3, entity.getCreatedAt());
        statement.bindLong(4, entity.getUpdatedAt());
        if (entity.getPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getPath());
        }
      }
    });
  }

  @Override
  public Object upsert(final MediaItemEntity item, final Continuation<? super Unit> $completion) {
    if (item == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __upsertAdapterOfMediaItemEntity.upsert(_connection, item);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object upsertAll(final List<MediaItemEntity> items,
      final Continuation<? super Unit> $completion) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __upsertAdapterOfMediaItemEntity.upsert(_connection, items);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getByAlbum(final String album,
      final Continuation<? super List<MediaItemEntity>> $completion) {
    final String _sql = "SELECT * FROM media_items WHERE album = ? ORDER BY createdAt DESC, updatedAt DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (album == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, album);
        }
        final int _columnIndexOfPath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "path");
        final int _columnIndexOfAlbum = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "album");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
        final List<MediaItemEntity> _result = new ArrayList<MediaItemEntity>();
        while (_stmt.step()) {
          final MediaItemEntity _item;
          final String _tmpPath;
          if (_stmt.isNull(_columnIndexOfPath)) {
            _tmpPath = null;
          } else {
            _tmpPath = _stmt.getText(_columnIndexOfPath);
          }
          final String _tmpAlbum;
          if (_stmt.isNull(_columnIndexOfAlbum)) {
            _tmpAlbum = null;
          } else {
            _tmpAlbum = _stmt.getText(_columnIndexOfAlbum);
          }
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          final long _tmpUpdatedAt;
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
          _item = new MediaItemEntity(_tmpPath,_tmpAlbum,_tmpCreatedAt,_tmpUpdatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object countAlbum(final String album, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM media_items WHERE album = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (album == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, album);
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
  public Object deleteByPaths(final List<String> paths,
      final Continuation<? super Unit> $completion) {
    final StringBuilder _stringBuilder = new StringBuilder();
    _stringBuilder.append("DELETE FROM media_items WHERE path IN (");
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
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteAlbumPaths(final String album, final List<String> paths,
      final Continuation<? super Unit> $completion) {
    final StringBuilder _stringBuilder = new StringBuilder();
    _stringBuilder.append("DELETE FROM media_items WHERE album = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND path IN (");
    final int _inputSize = paths.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (album == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, album);
        }
        _argIndex = 2;
        for (String _item : paths) {
          if (_item == null) {
            _stmt.bindNull(_argIndex);
          } else {
            _stmt.bindText(_argIndex, _item);
          }
          _argIndex++;
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
