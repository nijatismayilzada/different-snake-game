package com.thepot.differentsnakegame.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_INDEX_IN_GROUP;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_SAVE_ID;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_TYPE;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_X;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.CELL_Y;
import static com.thepot.differentsnakegame.repository.DatabaseDetails.CellTable.TABLE_CELL;
import static com.thepot.differentsnakegame.service.CageService.CELL_COUNT;

public class CellRepository {

    public static final int SAVE_ID_0 = 0;
    public static final int SAVE_ID_1 = 1;

    private SQLiteDatabase db;

    public CellRepository(DatabaseDetails databaseDetails) {
        this.db = databaseDetails.getWritableDatabase();
    }

    public void insertCage(Cage cage) {

        for (Cell[] cellCol : cage.cells) {
            for (Cell cell : cellCol) {
                ContentValues values = new ContentValues();
                values.put(CELL_X, cell.getX());
                values.put(CELL_Y, cell.getY());
                values.put(CELL_TYPE, cell.getCellType().name());
                values.put(CELL_INDEX_IN_GROUP, cell.getIndexInGroup());
                values.put(CELL_SAVE_ID, cell.getSaveId());
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

    public Cage getPlainCage(int saveId) {

        Cursor cursor = db.query(TABLE_CELL, null, CELL_SAVE_ID + " = ?",
                new String[]{String.valueOf(saveId)}, null, null, null);

        Cell[][] cells = new Cell[CELL_COUNT][CELL_COUNT];

        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                cursor.moveToNext();
                Cell cell = new Cell();
                cell.setX(cursor.getInt(cursor.getColumnIndex(CELL_X)));
                cell.setY(cursor.getInt(cursor.getColumnIndex(CELL_Y)));
                cell.setCellType(CellType.valueOf(cursor.getString(cursor.getColumnIndex(CELL_TYPE))));
                cell.setIndexInGroup(cursor.getInt(cursor.getColumnIndex(CELL_INDEX_IN_GROUP)));
                cell.setSaveId(cursor.getInt(cursor.getColumnIndex(CELL_SAVE_ID)));
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
        values.put(CELL_TYPE, cell.getCellType().name());
        values.put(CELL_INDEX_IN_GROUP, cell.getIndexInGroup());

        db.update(
                TABLE_CELL,
                values,
                CELL_X + " = ? AND " + CELL_Y + " = ? ",
                new String[]{String.valueOf(cell.getX()), String.valueOf(cell.getY())});

    }

    public void deleteAllCells() {
        db.delete(TABLE_CELL, null, null);
    }

}
