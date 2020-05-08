package com.thepot.differentsnakegame.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_INDEX_IN_GROUP;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_SAVE_ID;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_TYPE;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_X;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_Y;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.TABLE_CELL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_CURRENT_LEVEL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_MOVES_LEFT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_SAVE_ID;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.LEVEL_TRANSPARENT_WALL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.TABLE_LEVEL;

public class DatabaseDetails extends SQLiteOpenHelper {

    private static final String CREATE_CELL_TABLE = "CREATE TABLE " + TABLE_CELL + " (" +
            CELL_X + " INTEGER, " +
            CELL_Y + " INTEGER, " +
            CELL_TYPE + " TEXT, " +
            CELL_INDEX_IN_GROUP + " INTEGER, " +
            CELL_SAVE_ID + " INTEGER)";

    private static final String CREATE_LEVEL_TABLE = "CREATE TABLE " + TABLE_LEVEL + " (" +
            LEVEL_CURRENT_LEVEL + " REAL, " +
            LEVEL_MOVES_LEFT + " INTEGER, " +
            LEVEL_TRANSPARENT_WALL + " INTEGER, " +
            LEVEL_SAVE_ID + " INTEGER)";


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DifferentSnakeGame";

    public DatabaseDetails(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CELL_TABLE);
        db.execSQL(CREATE_LEVEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    static class CellTable implements BaseColumns {
        static final String TABLE_CELL = "cell";
        static final String CELL_X = "x";
        static final String CELL_Y = "y";
        static final String CELL_TYPE = "type";
        static final String CELL_INDEX_IN_GROUP = "index_in_group";
        static final String CELL_SAVE_ID = "save_id";
    }

    static class LevelTable implements BaseColumns {
        static final String TABLE_LEVEL = "level";
        static final String LEVEL_CURRENT_LEVEL = "current_level";
        static final String LEVEL_MOVES_LEFT = "moves_left";
        static final String LEVEL_TRANSPARENT_WALL = "transparent_wall";
        static final String LEVEL_SAVE_ID = "save_id";
    }
}
