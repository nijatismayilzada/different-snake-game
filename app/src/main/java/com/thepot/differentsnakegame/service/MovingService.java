package com.thepot.differentsnakegame.service;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

public class MovingService {

    private LevelHolder levelHolder;
    private Cage cage;
    private SnakeService snakeService;
    private Board board;

    public MovingService(LevelHolder levelHolder, Cage cage, SnakeService snakeService, Board board) {
        this.levelHolder = levelHolder;
        this.cage = cage;
        this.snakeService = snakeService;
        this.board = board;
    }


    public void makeNewHead(int Y, int X, CellType cellType) {
        levelHolder.getLevel().increaseMoveCount();
        Cell newHead = cage.cells[Y][X];
        if (newHead == levelHolder.getLevel().getMoveToNextLevel()) {
            levelHolder.loadNextLevel();
        }
        snakeService.addCell(newHead);
        newHead.setCellType(cellType);

        board.clearAndDraw();
    }
}
