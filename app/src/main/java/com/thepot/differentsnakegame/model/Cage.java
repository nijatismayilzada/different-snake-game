package com.thepot.differentsnakegame.model;

import android.graphics.Rect;

public class Cage {

    public static final int CELL_COUNT = 20;
    public static final int CELL_MAX_ID = CELL_COUNT - 1;
    public static final int CELL_MIN_ID = 0;

    public Cell[][] cells;
    public final int cellSize;


    public Cage(int availableWidth, int availableHeight) {
        this.cells = new Cell[CELL_COUNT][CELL_COUNT];

        cellSize = Math.min(availableWidth / CELL_COUNT, availableHeight / CELL_COUNT);

        int startX = (availableWidth - cellSize * CELL_COUNT) / 2;
        int startY = (availableHeight - cellSize * CELL_COUNT) / 2;

        int xCoordinate = startX;
        int yCoordinate = startY;

        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                Cell cell = new Cell();
                cell.setX(x);
                cell.setY(y);
                cell.setCellType(CellType.EMPTY);
                cell.setMoveToNextLevel(false);

                Rect rect = new Rect();
                rect.set(xCoordinate, yCoordinate, xCoordinate + cellSize, yCoordinate + cellSize);

                xCoordinate += cellSize;

                cell.setRect(rect);

                cells[y][x] = cell;
            }
            yCoordinate += cellSize;
            xCoordinate = startX;
        }
    }
}
