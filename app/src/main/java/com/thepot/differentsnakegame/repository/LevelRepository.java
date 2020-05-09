package com.thepot.differentsnakegame.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thepot.differentsnakegame.model.CurrentLevel;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_CURRENT_LEVEL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_MOVES_LEFT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_SAVE_ID;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_TRANSPARENT_WALL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.TABLE_LEVEL;

public class LevelRepository {


    private SQLiteDatabase db;

    public LevelRepository(DatabaseDetails databaseDetails) {
        this.db = databaseDetails.getWritableDatabase();
    }

    public void insertCurrentLevel(CurrentLevel currentLevel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LEVEL_CURRENT_LEVEL, currentLevel.getCurrentLevel());
        contentValues.put(LEVEL_MOVES_LEFT, currentLevel.getMovesLeft());
        contentValues.put(LEVEL_TRANSPARENT_WALL, currentLevel.isTransparentWall() ? 1 : 0);
        contentValues.put(LEVEL_SAVE_ID, currentLevel.getSaveId());
        db.insert(TABLE_LEVEL, null, contentValues);
    }

    public CurrentLevel getCurrentLevelDetails(int saveId) {
        Cursor cursor = db.query(TABLE_LEVEL, null, LEVEL_SAVE_ID + " = ?", new String[]{String.valueOf(saveId)}, null, null, null);

        if (cursor.moveToNext()) {

            CurrentLevel currentLevel = new CurrentLevel();
            currentLevel.setCurrentLevel(cursor.getDouble(cursor.getColumnIndex(LEVEL_CURRENT_LEVEL)));
            currentLevel.setMovesLeft(cursor.getInt(cursor.getColumnIndex(LEVEL_MOVES_LEFT)));
            currentLevel.setTransparentWall(cursor.getInt(cursor.getColumnIndex(LEVEL_TRANSPARENT_WALL)) == 1);
            currentLevel.setSaveId(cursor.getInt(cursor.getColumnIndex(LEVEL_SAVE_ID)));

            cursor.close();
            return currentLevel;
        }
        return null;
    }

    public void updateCurrentLevel(CurrentLevel currentLevel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(LEVEL_CURRENT_LEVEL, currentLevel.getCurrentLevel());
        contentValues.put(LEVEL_MOVES_LEFT, currentLevel.getMovesLeft());
        contentValues.put(LEVEL_TRANSPARENT_WALL, currentLevel.isTransparentWall() ? 1 : 0);

        db.update(TABLE_LEVEL,
                contentValues,
                LEVEL_SAVE_ID + " = ?",
                new String[]{String.valueOf(currentLevel.getSaveId())});

    }

    public void deleteLevelDetails() {
        db.delete(TABLE_LEVEL, null, null);
    }

    public void deleteLevelSave(int saveId) {
        db.delete(TABLE_LEVEL, LEVEL_SAVE_ID + " = ?", new String[]{String.valueOf(saveId)});
    }
}
