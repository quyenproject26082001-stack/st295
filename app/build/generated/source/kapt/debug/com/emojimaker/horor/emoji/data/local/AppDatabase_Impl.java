package com.emojimaker.horor.emoji.data.local;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.emojimaker.horor.emoji.data.local.dao.AppSettingDao;
import com.emojimaker.horor.emoji.data.local.dao.AppSettingDao_Impl;
import com.emojimaker.horor.emoji.data.local.dao.JsonCacheDao;
import com.emojimaker.horor.emoji.data.local.dao.JsonCacheDao_Impl;
import com.emojimaker.horor.emoji.data.local.dao.MakerCharacterDao;
import com.emojimaker.horor.emoji.data.local.dao.MakerCharacterDao_Impl;
import com.emojimaker.horor.emoji.data.local.dao.MediaItemDao;
import com.emojimaker.horor.emoji.data.local.dao.MediaItemDao_Impl;
import com.emojimaker.horor.emoji.data.local.dao.SavedAvatarDao;
import com.emojimaker.horor.emoji.data.local.dao.SavedAvatarDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile AppSettingDao _appSettingDao;

  private volatile JsonCacheDao _jsonCacheDao;

  private volatile MakerCharacterDao _makerCharacterDao;

  private volatile SavedAvatarDao _savedAvatarDao;

  private volatile MediaItemDao _mediaItemDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(3, "55343c4c7b2659be5a8dbac2def802ce", "d6e636af60f40d0857d209ab7c862498") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `app_settings` (`key` TEXT NOT NULL, `value` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`key`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `json_cache` (`key` TEXT NOT NULL, `json` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`key`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `maker_characters` (`id` TEXT NOT NULL, `source` TEXT NOT NULL, `dataName` TEXT NOT NULL, `avatar` TEXT NOT NULL, `level` INTEGER NOT NULL, `isFromApi` INTEGER NOT NULL, `sortOrder` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_maker_characters_source` ON `maker_characters` (`source`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_maker_characters_level_sortOrder` ON `maker_characters` (`level`, `sortOrder`)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_maker_characters_source_dataName` ON `maker_characters` (`source`, `dataName`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `maker_layer_groups` (`id` TEXT NOT NULL, `characterId` TEXT NOT NULL, `positionCustom` INTEGER NOT NULL, `positionNavigation` INTEGER NOT NULL, `imageNavigation` TEXT NOT NULL, `type` INTEGER NOT NULL, `sortOrder` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`characterId`) REFERENCES `maker_characters`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_maker_layer_groups_characterId_sortOrder` ON `maker_layer_groups` (`characterId`, `sortOrder`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `maker_layers` (`id` TEXT NOT NULL, `layerGroupId` TEXT NOT NULL, `image` TEXT NOT NULL, `isMoreColors` INTEGER NOT NULL, `thumb` TEXT NOT NULL, `sortOrder` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`layerGroupId`) REFERENCES `maker_layer_groups`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_maker_layers_layerGroupId_sortOrder` ON `maker_layers` (`layerGroupId`, `sortOrder`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `maker_colors` (`id` TEXT NOT NULL, `layerId` TEXT NOT NULL, `color` TEXT NOT NULL, `path` TEXT NOT NULL, `sortOrder` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`layerId`) REFERENCES `maker_layers`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_maker_colors_layerId_sortOrder` ON `maker_colors` (`layerId`, `sortOrder`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `saved_avatars` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `avatarPath` TEXT NOT NULL, `pathInternalEdit` TEXT NOT NULL, `suggestionJson` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_saved_avatars_pathInternalEdit` ON `saved_avatars` (`pathInternalEdit`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `media_items` (`path` TEXT NOT NULL, `album` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`path`))");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_media_items_album` ON `media_items` (`album`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '55343c4c7b2659be5a8dbac2def802ce')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `app_settings`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `json_cache`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `maker_characters`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `maker_layer_groups`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `maker_layers`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `maker_colors`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `saved_avatars`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `media_items`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsAppSettings = new HashMap<String, TableInfo.Column>(3);
        _columnsAppSettings.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppSettings.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysAppSettings = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesAppSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppSettings = new TableInfo("app_settings", _columnsAppSettings, _foreignKeysAppSettings, _indicesAppSettings);
        final TableInfo _existingAppSettings = TableInfo.read(connection, "app_settings");
        if (!_infoAppSettings.equals(_existingAppSettings)) {
          return new RoomOpenDelegate.ValidationResult(false, "app_settings(com.emojimaker.horor.emoji.data.local.entity.AppSettingEntity).\n"
                  + " Expected:\n" + _infoAppSettings + "\n"
                  + " Found:\n" + _existingAppSettings);
        }
        final Map<String, TableInfo.Column> _columnsJsonCache = new HashMap<String, TableInfo.Column>(3);
        _columnsJsonCache.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJsonCache.put("json", new TableInfo.Column("json", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJsonCache.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysJsonCache = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesJsonCache = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJsonCache = new TableInfo("json_cache", _columnsJsonCache, _foreignKeysJsonCache, _indicesJsonCache);
        final TableInfo _existingJsonCache = TableInfo.read(connection, "json_cache");
        if (!_infoJsonCache.equals(_existingJsonCache)) {
          return new RoomOpenDelegate.ValidationResult(false, "json_cache(com.emojimaker.horor.emoji.data.local.entity.JsonCacheEntity).\n"
                  + " Expected:\n" + _infoJsonCache + "\n"
                  + " Found:\n" + _existingJsonCache);
        }
        final Map<String, TableInfo.Column> _columnsMakerCharacters = new HashMap<String, TableInfo.Column>(8);
        _columnsMakerCharacters.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("dataName", new TableInfo.Column("dataName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("avatar", new TableInfo.Column("avatar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("isFromApi", new TableInfo.Column("isFromApi", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerCharacters.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMakerCharacters = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesMakerCharacters = new HashSet<TableInfo.Index>(3);
        _indicesMakerCharacters.add(new TableInfo.Index("index_maker_characters_source", false, Arrays.asList("source"), Arrays.asList("ASC")));
        _indicesMakerCharacters.add(new TableInfo.Index("index_maker_characters_level_sortOrder", false, Arrays.asList("level", "sortOrder"), Arrays.asList("ASC", "ASC")));
        _indicesMakerCharacters.add(new TableInfo.Index("index_maker_characters_source_dataName", true, Arrays.asList("source", "dataName"), Arrays.asList("ASC", "ASC")));
        final TableInfo _infoMakerCharacters = new TableInfo("maker_characters", _columnsMakerCharacters, _foreignKeysMakerCharacters, _indicesMakerCharacters);
        final TableInfo _existingMakerCharacters = TableInfo.read(connection, "maker_characters");
        if (!_infoMakerCharacters.equals(_existingMakerCharacters)) {
          return new RoomOpenDelegate.ValidationResult(false, "maker_characters(com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity).\n"
                  + " Expected:\n" + _infoMakerCharacters + "\n"
                  + " Found:\n" + _existingMakerCharacters);
        }
        final Map<String, TableInfo.Column> _columnsMakerLayerGroups = new HashMap<String, TableInfo.Column>(7);
        _columnsMakerLayerGroups.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("characterId", new TableInfo.Column("characterId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("positionCustom", new TableInfo.Column("positionCustom", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("positionNavigation", new TableInfo.Column("positionNavigation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("imageNavigation", new TableInfo.Column("imageNavigation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayerGroups.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMakerLayerGroups = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMakerLayerGroups.add(new TableInfo.ForeignKey("maker_characters", "CASCADE", "NO ACTION", Arrays.asList("characterId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesMakerLayerGroups = new HashSet<TableInfo.Index>(1);
        _indicesMakerLayerGroups.add(new TableInfo.Index("index_maker_layer_groups_characterId_sortOrder", false, Arrays.asList("characterId", "sortOrder"), Arrays.asList("ASC", "ASC")));
        final TableInfo _infoMakerLayerGroups = new TableInfo("maker_layer_groups", _columnsMakerLayerGroups, _foreignKeysMakerLayerGroups, _indicesMakerLayerGroups);
        final TableInfo _existingMakerLayerGroups = TableInfo.read(connection, "maker_layer_groups");
        if (!_infoMakerLayerGroups.equals(_existingMakerLayerGroups)) {
          return new RoomOpenDelegate.ValidationResult(false, "maker_layer_groups(com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity).\n"
                  + " Expected:\n" + _infoMakerLayerGroups + "\n"
                  + " Found:\n" + _existingMakerLayerGroups);
        }
        final Map<String, TableInfo.Column> _columnsMakerLayers = new HashMap<String, TableInfo.Column>(6);
        _columnsMakerLayers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayers.put("layerGroupId", new TableInfo.Column("layerGroupId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayers.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayers.put("isMoreColors", new TableInfo.Column("isMoreColors", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayers.put("thumb", new TableInfo.Column("thumb", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerLayers.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMakerLayers = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMakerLayers.add(new TableInfo.ForeignKey("maker_layer_groups", "CASCADE", "NO ACTION", Arrays.asList("layerGroupId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesMakerLayers = new HashSet<TableInfo.Index>(1);
        _indicesMakerLayers.add(new TableInfo.Index("index_maker_layers_layerGroupId_sortOrder", false, Arrays.asList("layerGroupId", "sortOrder"), Arrays.asList("ASC", "ASC")));
        final TableInfo _infoMakerLayers = new TableInfo("maker_layers", _columnsMakerLayers, _foreignKeysMakerLayers, _indicesMakerLayers);
        final TableInfo _existingMakerLayers = TableInfo.read(connection, "maker_layers");
        if (!_infoMakerLayers.equals(_existingMakerLayers)) {
          return new RoomOpenDelegate.ValidationResult(false, "maker_layers(com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity).\n"
                  + " Expected:\n" + _infoMakerLayers + "\n"
                  + " Found:\n" + _existingMakerLayers);
        }
        final Map<String, TableInfo.Column> _columnsMakerColors = new HashMap<String, TableInfo.Column>(5);
        _columnsMakerColors.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerColors.put("layerId", new TableInfo.Column("layerId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerColors.put("color", new TableInfo.Column("color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerColors.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMakerColors.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMakerColors = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMakerColors.add(new TableInfo.ForeignKey("maker_layers", "CASCADE", "NO ACTION", Arrays.asList("layerId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesMakerColors = new HashSet<TableInfo.Index>(1);
        _indicesMakerColors.add(new TableInfo.Index("index_maker_colors_layerId_sortOrder", false, Arrays.asList("layerId", "sortOrder"), Arrays.asList("ASC", "ASC")));
        final TableInfo _infoMakerColors = new TableInfo("maker_colors", _columnsMakerColors, _foreignKeysMakerColors, _indicesMakerColors);
        final TableInfo _existingMakerColors = TableInfo.read(connection, "maker_colors");
        if (!_infoMakerColors.equals(_existingMakerColors)) {
          return new RoomOpenDelegate.ValidationResult(false, "maker_colors(com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity).\n"
                  + " Expected:\n" + _infoMakerColors + "\n"
                  + " Found:\n" + _existingMakerColors);
        }
        final Map<String, TableInfo.Column> _columnsSavedAvatars = new HashMap<String, TableInfo.Column>(6);
        _columnsSavedAvatars.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAvatars.put("avatarPath", new TableInfo.Column("avatarPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAvatars.put("pathInternalEdit", new TableInfo.Column("pathInternalEdit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAvatars.put("suggestionJson", new TableInfo.Column("suggestionJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAvatars.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAvatars.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysSavedAvatars = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesSavedAvatars = new HashSet<TableInfo.Index>(1);
        _indicesSavedAvatars.add(new TableInfo.Index("index_saved_avatars_pathInternalEdit", true, Arrays.asList("pathInternalEdit"), Arrays.asList("ASC")));
        final TableInfo _infoSavedAvatars = new TableInfo("saved_avatars", _columnsSavedAvatars, _foreignKeysSavedAvatars, _indicesSavedAvatars);
        final TableInfo _existingSavedAvatars = TableInfo.read(connection, "saved_avatars");
        if (!_infoSavedAvatars.equals(_existingSavedAvatars)) {
          return new RoomOpenDelegate.ValidationResult(false, "saved_avatars(com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity).\n"
                  + " Expected:\n" + _infoSavedAvatars + "\n"
                  + " Found:\n" + _existingSavedAvatars);
        }
        final Map<String, TableInfo.Column> _columnsMediaItems = new HashMap<String, TableInfo.Column>(4);
        _columnsMediaItems.put("path", new TableInfo.Column("path", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaItems.put("album", new TableInfo.Column("album", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaItems.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaItems.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMediaItems = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesMediaItems = new HashSet<TableInfo.Index>(1);
        _indicesMediaItems.add(new TableInfo.Index("index_media_items_album", false, Arrays.asList("album"), Arrays.asList("ASC")));
        final TableInfo _infoMediaItems = new TableInfo("media_items", _columnsMediaItems, _foreignKeysMediaItems, _indicesMediaItems);
        final TableInfo _existingMediaItems = TableInfo.read(connection, "media_items");
        if (!_infoMediaItems.equals(_existingMediaItems)) {
          return new RoomOpenDelegate.ValidationResult(false, "media_items(com.emojimaker.horor.emoji.data.local.entity.MediaItemEntity).\n"
                  + " Expected:\n" + _infoMediaItems + "\n"
                  + " Found:\n" + _existingMediaItems);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "app_settings", "json_cache", "maker_characters", "maker_layer_groups", "maker_layers", "maker_colors", "saved_avatars", "media_items");
  }

  @Override
  public void clearAllTables() {
    super.performClear(true, "app_settings", "json_cache", "maker_characters", "maker_layer_groups", "maker_layers", "maker_colors", "saved_avatars", "media_items");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AppSettingDao.class, AppSettingDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(JsonCacheDao.class, JsonCacheDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MakerCharacterDao.class, MakerCharacterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SavedAvatarDao.class, SavedAvatarDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MediaItemDao.class, MediaItemDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
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
  public AppSettingDao appSettingDao() {
    if (_appSettingDao != null) {
      return _appSettingDao;
    } else {
      synchronized(this) {
        if(_appSettingDao == null) {
          _appSettingDao = new AppSettingDao_Impl(this);
        }
        return _appSettingDao;
      }
    }
  }

  @Override
  public JsonCacheDao jsonCacheDao() {
    if (_jsonCacheDao != null) {
      return _jsonCacheDao;
    } else {
      synchronized(this) {
        if(_jsonCacheDao == null) {
          _jsonCacheDao = new JsonCacheDao_Impl(this);
        }
        return _jsonCacheDao;
      }
    }
  }

  @Override
  public MakerCharacterDao makerCharacterDao() {
    if (_makerCharacterDao != null) {
      return _makerCharacterDao;
    } else {
      synchronized(this) {
        if(_makerCharacterDao == null) {
          _makerCharacterDao = new MakerCharacterDao_Impl(this);
        }
        return _makerCharacterDao;
      }
    }
  }

  @Override
  public SavedAvatarDao savedAvatarDao() {
    if (_savedAvatarDao != null) {
      return _savedAvatarDao;
    } else {
      synchronized(this) {
        if(_savedAvatarDao == null) {
          _savedAvatarDao = new SavedAvatarDao_Impl(this);
        }
        return _savedAvatarDao;
      }
    }
  }

  @Override
  public MediaItemDao mediaItemDao() {
    if (_mediaItemDao != null) {
      return _mediaItemDao;
    } else {
      synchronized(this) {
        if(_mediaItemDao == null) {
          _mediaItemDao = new MediaItemDao_Impl(this);
        }
        return _mediaItemDao;
      }
    }
  }
}
