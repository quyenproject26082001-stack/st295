package com.emojimaker.horor.emoji.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity

@Dao
interface MakerCharacterDao {
    @Query("SELECT * FROM maker_characters ORDER BY level ASC, CASE source WHEN 'local' THEN 0 ELSE 1 END, sortOrder ASC")
    suspend fun getCharacters(): List<MakerCharacterEntity>

    @Query("SELECT * FROM maker_layer_groups ORDER BY characterId, sortOrder")
    suspend fun getAllLayerGroups(): List<MakerLayerGroupEntity>

    @Query("SELECT * FROM maker_layers ORDER BY layerGroupId, sortOrder")
    suspend fun getAllLayers(): List<MakerLayerEntity>

    @Query("SELECT * FROM maker_colors ORDER BY layerId, sortOrder")
    suspend fun getAllColors(): List<MakerColorEntity>

    @Query("SELECT COUNT(*) FROM maker_characters WHERE source = :source")
    suspend fun countBySource(source: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(items: List<MakerCharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLayerGroups(items: List<MakerLayerGroupEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLayers(items: List<MakerLayerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColors(items: List<MakerColorEntity>)

    @Query("DELETE FROM maker_characters WHERE source = :source")
    suspend fun deleteBySource(source: String): Int
}
