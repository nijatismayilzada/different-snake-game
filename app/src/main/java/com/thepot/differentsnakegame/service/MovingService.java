package com.thepot.differentsnakegame.service;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;

public class MovingService {

    private LevelHolder levelHolder;
    private Cage cage;
    private Snake snake;
    private Board board;

    public MovingService(LevelHolder levelHolder, Cage cage, Snake snake, Board board) {
        this.levelHolder = levelHolder;
        this.cage = cage;
        this.snake = snake;
        this.board = board;
    }


    public void makeNewHead(int Y, int X, CellType cellType) {
        levelHolder.getLevel().increaseMoveCount();
        Cell newHead = cage.cells[Y][X];
        if (newHead.isMoveToNextLevel()) {
            levelHolder.loadNextLevel();
            newHead.setMoveToNextLevel(false);
        }
        snake.addCell(newHead);
        newHead.setCellType(cellType);

        board.clearAndDraw();
    }
}
