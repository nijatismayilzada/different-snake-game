package com.thepot.differentsnakegame.model;

import android.graphics.Rect;

public class Cell {
    private int x;
    private int y;
    private CellType cellType;
    private Rect rect;
    private boolean moveToNextLevel;

    public Cell() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public boolean isMoveToNextLevel() {
        return moveToNextLevel;
    }

    public void setMoveToNextLevel(boolean moveToNextLevel) {
        this.moveToNextLevel = moveToNextLevel;
    }
}
