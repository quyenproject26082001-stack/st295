package com.emojimaker.horor.emoji.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity;
import com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity;
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity;
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class MakerCharacterDao_Impl implements MakerCharacterDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<MakerCharacterEntity> __insertAdapterOfMakerCharacterEntity;

  private final EntityInsertAdapter<MakerLayerGroupEntity> __insertAdapterOfMakerLayerGroupEntity;

  private final EntityInsertAdapter<MakerLayerEntity> __insertAdapterOfMakerLayerEntity;

  private final EntityInsertAdapter<MakerColorEntity> __insertAdapterOfMakerColorEntity;

  public MakerCharacterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfMakerCharacterEntity = new EntityInsertAdapter<MakerCharacterEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `maker_characters` (`id`,`source`,`dataName`,`avatar`,`level`,`isFromApi`,`sortOrder`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MakerCharacterEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getSource() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getSource());
        }
        if (entity.getDataName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getDataName());
        }
        if (entity.getAvatar() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getAvatar());
        }
        statement.bindLong(5, entity.getLevel());
        final int _tmp = entity.isFromApi() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getSortOrder());
        statement.bindLong(8, entity.getUpdatedAt());
      }
    };
    this.__insertAdapterOfMakerLayerGroupEntity = new EntityInsertAdapter<MakerLayerGroupEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `maker_layer_groups` (`id`,`characterId`,`positionCustom`,`positionNavigation`,`imageNavigation`,`type`,`sortOrder`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MakerLayerGroupEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getCharacterId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getCharacterId());
        }
        statement.bindLong(3, entity.getPositionCustom());
        statement.bindLong(4, entity.getPositionNavigation());
        if (entity.getImageNavigation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getImageNavigation());
        }
        statement.bindLong(6, entity.getType());
        statement.bindLong(7, entity.getSortOrder());
      }
    };
    this.__insertAdapterOfMakerLayerEntity = new EntityInsertAdapter<MakerLayerEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `maker_layers` (`id`,`layerGroupId`,`image`,`isMoreColors`,`thumb`,`sortOrder`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MakerLayerEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getLayerGroupId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getLayerGroupId());
        }
        if (entity.getImage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getImage());
        }
        final int _tmp = entity.isMoreColors() ? 1 : 0;
        statement.bindLong(4, _tmp);
        if (entity.getThumb() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getThumb());
        }
        statement.bindLong(6, entity.getSortOrder());
      }
    };
    this.__insertAdapterOfMakerColorEntity = new EntityInsertAdapter<MakerColorEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `maker_colors` (`id`,`layerId`,`color`,`path`,`sortOrder`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MakerColorEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getLayerId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getLayerId());
        }
        if (entity.getColor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getColor());
        }
        if (entity.getPath() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getPath());
        }
        statement.bindLong(5, entity.getSortOrder());
      }
    };
  }

  @Override
  public Object insertCharacters(final List<MakerCharacterEntity> items,
      final Continuation<? super Unit> $completion) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMakerCharacterEntity.insert(_connection, items);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertLayerGroups(final List<MakerLayerGroupEntity> items,
      final Continuation<? super Unit> $completion) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMakerLayerGroupEntity.insert(_connection, items);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertLayers(final List<MakerLayerEntity> items,
      final Continuation<? super Unit> $completion) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMakerLayerEntity.insert(_connection, items);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertColors(final List<MakerColorEntity> items,
      final Continuation<? super Unit> $completion) {
    if (items == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMakerColorEntity.insert(_connection, items);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getCharacters(final Continuation<? super List<MakerCharacterEntity>> $completion) {
    final String _sql = "SELECT * FROM maker_characters ORDER BY level ASC, CASE source WHEN 'local' THEN 0 ELSE 1 END, sortOrder ASC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfSource = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "source");
        final int _columnIndexOfDataName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dataName");
        final int _columnIndexOfAvatar = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "avatar");
        final int _columnIndexOfLevel = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "level");
        final int _columnIndexOfIsFromApi = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isFromApi");
        final int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sortOrder");
        final int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
        final List<MakerCharacterEntity> _result = new ArrayList<MakerCharacterEntity>();
        while (_stmt.step()) {
          final MakerCharacterEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpSource;
          if (_stmt.isNull(_columnIndexOfSource)) {
            _tmpSource = null;
          } else {
            _tmpSource = _stmt.getText(_columnIndexOfSource);
          }
          final String _tmpDataName;
          if (_stmt.isNull(_columnIndexOfDataName)) {
            _tmpDataName = null;
          } else {
            _tmpDataName = _stmt.getText(_columnIndexOfDataName);
          }
          final String _tmpAvatar;
          if (_stmt.isNull(_columnIndexOfAvatar)) {
            _tmpAvatar = null;
          } else {
            _tmpAvatar = _stmt.getText(_columnIndexOfAvatar);
          }
          final int _tmpLevel;
          _tmpLevel = (int) (_stmt.getLong(_columnIndexOfLevel));
          final boolean _tmpIsFromApi;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsFromApi));
          _tmpIsFromApi = _tmp != 0;
          final int _tmpSortOrder;
          _tmpSortOrder = (int) (_stmt.getLong(_columnIndexOfSortOrder));
          final long _tmpUpdatedAt;
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
          _item = new MakerCharacterEntity(_tmpId,_tmpSource,_tmpDataName,_tmpAvatar,_tmpLevel,_tmpIsFromApi,_tmpSortOrder,_tmpUpdatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getAllLayerGroups(
      final Continuation<? super List<MakerLayerGroupEntity>> $completion) {
    final String _sql = "SELECT * FROM maker_layer_groups ORDER BY characterId, sortOrder";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfCharacterId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "characterId");
        final int _columnIndexOfPositionCustom = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "positionCustom");
        final int _columnIndexOfPositionNavigation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "positionNavigation");
        final int _columnIndexOfImageNavigation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageNavigation");
        final int _columnIndexOfType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "type");
        final int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sortOrder");
        final List<MakerLayerGroupEntity> _result = new ArrayList<MakerLayerGroupEntity>();
        while (_stmt.step()) {
          final MakerLayerGroupEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpCharacterId;
          if (_stmt.isNull(_columnIndexOfCharacterId)) {
            _tmpCharacterId = null;
          } else {
            _tmpCharacterId = _stmt.getText(_columnIndexOfCharacterId);
          }
          final int _tmpPositionCustom;
          _tmpPositionCustom = (int) (_stmt.getLong(_columnIndexOfPositionCustom));
          final int _tmpPositionNavigation;
          _tmpPositionNavigation = (int) (_stmt.getLong(_columnIndexOfPositionNavigation));
          final String _tmpImageNavigation;
          if (_stmt.isNull(_columnIndexOfImageNavigation)) {
            _tmpImageNavigation = null;
          } else {
            _tmpImageNavigation = _stmt.getText(_columnIndexOfImageNavigation);
          }
          final int _tmpType;
          _tmpType = (int) (_stmt.getLong(_columnIndexOfType));
          final int _tmpSortOrder;
          _tmpSortOrder = (int) (_stmt.getLong(_columnIndexOfSortOrder));
          _item = new MakerLayerGroupEntity(_tmpId,_tmpCharacterId,_tmpPositionCustom,_tmpPositionNavigation,_tmpImageNavigation,_tmpType,_tmpSortOrder);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getAllLayers(final Continuation<? super List<MakerLayerEntity>> $completion) {
    final String _sql = "SELECT * FROM maker_layers ORDER BY layerGroupId, sortOrder";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfLayerGroupId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "layerGroupId");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfIsMoreColors = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isMoreColors");
        final int _columnIndexOfThumb = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "thumb");
        final int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sortOrder");
        final List<MakerLayerEntity> _result = new ArrayList<MakerLayerEntity>();
        while (_stmt.step()) {
          final MakerLayerEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpLayerGroupId;
          if (_stmt.isNull(_columnIndexOfLayerGroupId)) {
            _tmpLayerGroupId = null;
          } else {
            _tmpLayerGroupId = _stmt.getText(_columnIndexOfLayerGroupId);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final boolean _tmpIsMoreColors;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsMoreColors));
          _tmpIsMoreColors = _tmp != 0;
          final String _tmpThumb;
          if (_stmt.isNull(_columnIndexOfThumb)) {
            _tmpThumb = null;
          } else {
            _tmpThumb = _stmt.getText(_columnIndexOfThumb);
          }
          final int _tmpSortOrder;
          _tmpSortOrder = (int) (_stmt.getLong(_columnIndexOfSortOrder));
          _item = new MakerLayerEntity(_tmpId,_tmpLayerGroupId,_tmpImage,_tmpIsMoreColors,_tmpThumb,_tmpSortOrder);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getAllColors(final Continuation<? super List<MakerColorEntity>> $completion) {
    final String _sql = "SELECT * FROM maker_colors ORDER BY layerId, sortOrder";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfLayerId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "layerId");
        final int _columnIndexOfColor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "color");
        final int _columnIndexOfPath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "path");
        final int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sortOrder");
        final List<MakerColorEntity> _result = new ArrayList<MakerColorEntity>();
        while (_stmt.step()) {
          final MakerColorEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpLayerId;
          if (_stmt.isNull(_columnIndexOfLayerId)) {
            _tmpLayerId = null;
          } else {
            _tmpLayerId = _stmt.getText(_columnIndexOfLayerId);
          }
          final String _tmpColor;
          if (_stmt.isNull(_columnIndexOfColor)) {
            _tmpColor = null;
          } else {
            _tmpColor = _stmt.getText(_columnIndexOfColor);
          }
          final String _tmpPath;
          if (_stmt.isNull(_columnIndexOfPath)) {
            _tmpPath = null;
          } else {
            _tmpPath = _stmt.getText(_columnIndexOfPath);
          }
          final int _tmpSortOrder;
          _tmpSortOrder = (int) (_stmt.getLong(_columnIndexOfSortOrder));
          _item = new MakerColorEntity(_tmpId,_tmpLayerId,_tmpColor,_tmpPath,_tmpSortOrder);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object countBySource(final String source,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM maker_characters WHERE source = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (source == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, source);
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
  public Object deleteBySource(final String source,
      final Continuation<? super Integer> $completion) {
    final String _sql = "DELETE FROM maker_characters WHERE source = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (source == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, source);
        }
        _stmt.step();
        return SQLiteConnectionUtil.getTotalChangedRows(_connection);
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
