package com.emojimaker.horor.emoji.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseMigrations {
    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL(
                """CREATE TABLE IF NOT EXISTS `maker_characters` (
                    `id` TEXT NOT NULL, `source` TEXT NOT NULL, `dataName` TEXT NOT NULL,
                    `avatar` TEXT NOT NULL, `level` INTEGER NOT NULL, `isFromApi` INTEGER NOT NULL,
                    `sortOrder` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL,
                    PRIMARY KEY(`id`))"""
            )
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_maker_characters_source` ON `maker_characters` (`source`)")
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_maker_characters_level_sortOrder` ON `maker_characters` (`level`, `sortOrder`)")
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_maker_characters_source_dataName` ON `maker_characters` (`source`, `dataName`)")

            db.execSQL(
                """CREATE TABLE IF NOT EXISTS `maker_layer_groups` (
                    `id` TEXT NOT NULL, `characterId` TEXT NOT NULL, `positionCustom` INTEGER NOT NULL,
                    `positionNavigation` INTEGER NOT NULL, `imageNavigation` TEXT NOT NULL,
                    `type` INTEGER NOT NULL, `sortOrder` INTEGER NOT NULL, PRIMARY KEY(`id`),
                    FOREIGN KEY(`characterId`) REFERENCES `maker_characters`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE)"""
            )
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_maker_layer_groups_characterId_sortOrder` ON `maker_layer_groups` (`characterId`, `sortOrder`)")

            db.execSQL(
                """CREATE TABLE IF NOT EXISTS `maker_layers` (
                    `id` TEXT NOT NULL, `layerGroupId` TEXT NOT NULL, `image` TEXT NOT NULL,
                    `isMoreColors` INTEGER NOT NULL, `thumb` TEXT NOT NULL, `sortOrder` INTEGER NOT NULL,
                    PRIMARY KEY(`id`), FOREIGN KEY(`layerGroupId`) REFERENCES `maker_layer_groups`(`id`)
                    ON UPDATE NO ACTION ON DELETE CASCADE)"""
            )
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_maker_layers_layerGroupId_sortOrder` ON `maker_layers` (`layerGroupId`, `sortOrder`)")

            db.execSQL(
                """CREATE TABLE IF NOT EXISTS `maker_colors` (
                    `id` TEXT NOT NULL, `layerId` TEXT NOT NULL, `color` TEXT NOT NULL,
                    `path` TEXT NOT NULL, `sortOrder` INTEGER NOT NULL, PRIMARY KEY(`id`),
                    FOREIGN KEY(`layerId`) REFERENCES `maker_layers`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE)"""
            )
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_maker_colors_layerId_sortOrder` ON `maker_colors` (`layerId`, `sortOrder`)")
        }
    }
}
