package com.thepot.differentsnakegame.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.thepot.differentsnakegame.level.CurrentLevel;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.DATABASE_NAME;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.DATABASE_VERSION;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_CURRENT_LEVEL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_MOVES_LEFT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.TABLE_LEVEL;

public class LevelRepository extends SQLiteOpenHelper {

    private static final String CREATE_LEVEL_TABLE = "CREATE TABLE " + TABLE_LEVEL + " (" +
            COLUMN_CURRENT_LEVEL + " INTEGER, " +
            COLUMN_MOVES_LEFT + " INTEGER)";

    private SQLiteDatabase db;

    public LevelRepository(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LEVEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertCurrentLevel(CurrentLevel currentLevel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CURRENT_LEVEL, currentLevel.getCurrentLevel());
        contentValues.put(COLUMN_MOVES_LEFT, currentLevel.getMovesLeft());
        db.insert(TABLE_LEVEL, null, contentValues);
    }

    public CurrentLevel getCurrentLevelDetails() {
        Cursor cursor = db.query(TABLE_LEVEL, null, null, null, null, null, null);

        cursor.moveToNext();

        CurrentLevel currentLevel = new CurrentLevel();
        currentLevel.setCurrentLevel(cursor.getInt(cursor.getColumnIndex(COLUMN_CURRENT_LEVEL)));
        currentLevel.setMovesLeft(cursor.getInt(cursor.getColumnIndex(COLUMN_MOVES_LEFT)));

        cursor.close();
        return currentLevel;
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
