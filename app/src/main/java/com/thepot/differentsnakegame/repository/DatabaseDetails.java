package com.thepot.differentsnakegame.repository;

import android.provider.BaseColumns;

class DatabaseDetails {

    private DatabaseDetails() {
    }

    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "DifferentSnakeGame";

    static class CellTable implements BaseColumns {
        static final String TABLE_CELL = "cell";
        static final String COLUMN_CELL_X = "cell_x";
        static final String COLUMN_CELL_Y = "cell_y";
        static final String COLUMN_CELL_TYPE = "cell_type";
    }

    static class LevelTable implements BaseColumns {
        static final String TABLE_LEVEL = "level";
        static final String COLUMN_CURRENT_LEVEL = "current_level";
        static final String COLUMN_MOVES_LEFT = "moves_left";
    }
}
