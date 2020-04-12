package com.thepot.differentsnakegame.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thepot.differentsnakegame.model.CurrentLevel;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_CURRENT_LEVEL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_MOVES_LEFT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.TABLE_LEVEL;

public class LevelRepository {


    private SQLiteDatabase db;

    public LevelRepository(DatabaseDetails databaseDetails) {
        this.db = databaseDetails.getWritableDatabase();
    }

    public void insertCurrentLevel(CurrentLevel currentLevel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CURRENT_LEVEL, currentLevel.getCurrentLevel());
        contentValues.put(COLUMN_MOVES_LEFT, currentLevel.getMovesLeft());
        db.insert(TABLE_LEVEL, null, contentValues);
    }

    public CurrentLevel getCurrentLevelDetails() {
        Cursor cursor = db.query(TABLE_LEVEL, null, null, null, null, null, null);

        if (cursor.moveToNext()) {

            CurrentLevel currentLevel = new CurrentLevel();
            currentLevel.setCurrentLevel(cursor.getInt(cursor.getColumnIndex(COLUMN_CURRENT_LEVEL)));
            currentLevel.setMovesLeft(cursor.getInt(cursor.getColumnIndex(COLUMN_MOVES_LEFT)));

            cursor.close();
            return currentLevel;
        }
        return null;
    }

    public void updateCurrentLevel(CurrentLevel currentLevel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CURRENT_LEVEL, currentLevel.getCurrentLevel());
        contentValues.put(COLUMN_MOVES_LEFT, currentLevel.getMovesLeft());

        int count = db.update(
                TABLE_LEVEL,
                contentValues,
                null,
                null);

    }

    public void deleteLevelDetails() {
        db.delete(TABLE_LEVEL, null, null);
    }
}
