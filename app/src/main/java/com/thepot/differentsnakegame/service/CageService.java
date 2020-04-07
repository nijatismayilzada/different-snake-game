package com.thepot.differentsnakegame.service;

import android.graphics.Rect;
import android.widget.ImageView;

import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.repository.CellRepository;

import java.util.ArrayList;
import java.util.List;

import static com.thepot.differentsnakegame.model.Cage.CELL_COUNT;

public class CageService {
    private CellRepository cellRepository;
    private ImageView boardHolder;

    //Caching//
    private Cage cage;
    private Integer cellSize;
    ///////////

    public CageService(CellRepository cellRepository, ImageView boardHolder) {
        this.cellRepository = cellRepository;
        this.boardHolder = boardHolder;
    }

    public void updateCellTypeForCell(Cell cell, CellType cellType) {
        cell.setCellType(cellType);
        cellRepository.updateCell(cell);
    }

    public List<Cell> findCellsOfTypes(CellType... cellTypes) {
        List<Cell> cellsFound = new ArrayList<>();

        for (Cell[] cellCol : getCage().cells) {
            for (Cell cell : cellCol) {
                for (CellType cellType : cellTypes) {
                    if (cell.getCellType() == cellType) {
                        cellsFound.add(cell);
                    }
                }
            }
        }
        return cellsFound;
    }

    public Cage getCage() {

        if (cage == null) {
            if (cellRepository.cageExists()) {
                cage = cellRepository.getPlainCage();
            } else {
                cage = new Cage();
                cage.setCells(generateCells());
                cellRepository.insertCage(cage);
            }
            initialiseRects();
        }

        return cage;
    }

    private Cell[][] generateCells() {
        Cell[][] cells = new Cell[CELL_COUNT][CELL_COUNT];
        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                cells[y][x] = generateCell(y, x);
            }
        }
        return cells;
    }

    private Cell generateCell(int y, int x) {
        Cell cell = new Cell();
        cell.setX(x);
        cell.setY(y);
        cell.setCellType(CellType.EMPTY);
        return cell;
    }

    private void initialiseRects() {

        int startX = (boardHolder.getMeasuredWidth() - getCellSize() * CELL_COUNT) / 2;
        int startY = (boardHolder.getMeasuredHeight() - getCellSize() * CELL_COUNT) / 2;

        int xCoordinate = startX;
        int yCoordinate = startY;

        for (Cell[] cellCol : cage.cells) {
            for (Cell cell : cellCol) {
                Rect rect = new Rect();
                rect.set(xCoordinate, yCoordinate, xCoordinate + getCellSize(), yCoordinate + getCellSize());

                xCoordinate += getCellSize();
                cell.setRect(rect);
            }
            yCoordinate += getCellSize();
            xCoordinate = startX;
        }
    }

    public int getCellSize() {
        if (cellSize == null) {
            cellSize = Math.min(boardHolder.getMeasuredWidth() / CELL_COUNT, boardHolder.getMeasuredHeight() / CELL_COUNT);
        }

        return cellSize;
    }
}