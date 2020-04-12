package com.thepot.differentsnakegame.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_INDEX_IN_GROUP;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_TYPE;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_X;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_Y;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.TABLE_CELL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_CURRENT_LEVEL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.COLUMN_MOVES_LEFT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.LevelTable.TABLE_LEVEL;

public class DatabaseDetails extends SQLiteOpenHelper {

    private static final String CREATE_CELL_TABLE = "CREATE TABLE " + TABLE_CELL + " (" +
            COLUMN_CELL_X + " INTEGER, " +
            COLUMN_CELL_Y + " INTEGER, " +
            COLUMN_CELL_TYPE + " TEXT, " +
            COLUMN_CELL_INDEX_IN_GROUP + " INTEGER)";

    private static final String CREATE_LEVEL_TABLE = "CREATE TABLE " + TABLE_LEVEL + " (" +
            COLUMN_CURRENT_LEVEL + " INTEGER, " +
            COLUMN_MOVES_LEFT + " INTEGER)";


    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "DifferentSnakeGame";

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
        static final String COLUMN_CELL_X = "cell_x";
        static final String COLUMN_CELL_Y = "cell_y";
        static final String COLUMN_CELL_TYPE = "type";
        static final String COLUMN_CELL_INDEX_IN_GROUP = "index_in_group";
    }

    static class LevelTable implements BaseColumns {
        static final String TABLE_LEVEL = "level";
        static final String COLUMN_CURRENT_LEVEL = "current_level";
        static final String COLUMN_MOVES_LEFT = "moves_left";
    }
}
