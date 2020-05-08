package com.thepot.differentsnakegame.model;

import android.graphics.Rect;

public class Cell implements Comparable<Cell> {
    private int x;
    private int y;
    private CellType cellType;
    private int indexInGroup;
    private int saveId;
    private Rect rect;

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

    public int getIndexInGroup() {
        return indexInGroup;
    }

    public void setIndexInGroup(int indexInGroup) {
        this.indexInGroup = indexInGroup;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getSaveId() {
        return saveId;
    }

    public void setSaveId(int saveId) {
        this.saveId = saveId;
    }

    @Override
    public int compareTo(Cell o) {
        return this.indexInGroup - o.indexInGroup;
    }
}
