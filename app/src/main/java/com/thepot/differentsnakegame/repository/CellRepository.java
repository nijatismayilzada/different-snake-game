package com.thepot.differentsnakegame.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

import static com.thepot.differentsnakegame.model.Cage.CELL_COUNT;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_TYPE;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_X;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.COLUMN_CELL_Y;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.TABLE_CELL;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.DATABASE_NAME;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.DATABASE_VERSION;

public class CellRepository extends SQLiteOpenHelper {

    private static final String CREATE_CELL_TABLE = "CREATE TABLE " + TABLE_CELL + " (" +
            COLUMN_CELL_X + " INTEGER, " +
            COLUMN_CELL_Y + " INTEGER, " +
            COLUMN_CELL_TYPE + " TEXT)";

    private SQLiteDatabase db;

    public CellRepository(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CELL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertCage(Cage cage) {

        for (Cell[] cellCol : cage.cells) {
            for (Cell cell : cellCol) {
                ContentValues values = new ContentValues();
                values.put(COLUMN_CELL_X, cell.getX());
                values.put(COLUMN_CELL_Y, cell.getY());
                values.put(COLUMN_CELL_TYPE, cell.getCellType().name());
                db.insert(TABLE_CELL, null, values);
            }
        }
    }

    public boolean cageExists() {
        Cursor cursor = db.query(TABLE_CELL, null, null, null, null, null, null);
        boolean cageExists = cursor.moveToNext();
        cursor.close();
        return cageExists;
    }

    public Cage getPlainCage() {

        Cursor cursor = db.query(TABLE_CELL, null, null, null, null, null, null);

        Cell[][] cells = new Cell[CELL_COUNT][CELL_COUNT];

        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                cursor.moveToNext();
                Cell cell = new Cell();
                cell.setX(cursor.getInt(cursor.getColumnIndex(COLUMN_CELL_X)));
                cell.setY(cursor.getInt(cursor.getColumnIndex(COLUMN_CELL_Y)));
                cell.setCellType(CellType.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_CELL_TYPE))));
                cells[y][x] = cell;
            }
        }
        cursor.close();
        Cage cage = new Cage();
        cage.setCells(cells);
        return cage;
    }

    public void updateCell(Cell cell) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_CELL_TYPE, cell.getCellType().name());

        String selection = COLUMN_CELL_X + " = ? AND " + COLUMN_CELL_Y + " = ? ";
        String[] selectionArgs = {String.valueOf(cell.getX()), String.valueOf(cell.getY())};

        db.update(
                TABLE_CELL,
                values,
                selection,
                selectionArgs);

    }

    public void deleteAllCells() {
        db.delete(TABLE_CELL, null, null);
    }

}
