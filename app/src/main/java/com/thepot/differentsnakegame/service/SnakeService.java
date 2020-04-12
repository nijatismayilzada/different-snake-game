package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;

import java.util.Collections;

import static com.thepot.differentsnakegame.service.CageService.CELL_COUNT;

public class SnakeService {
    private CageService cageService;
    private LevelService levelService;
    private Board board;

    private Snake snake;

    public SnakeService(CageService cageService, LevelService levelService, Board board) {
        this.cageService = cageService;
        this.levelService = levelService;
        this.board = board;
    }

    public Snake getSnake() {

        if (snake == null) {
            snake = new Snake();
            snake.snakeBody.addAll(cageService.findCellsOfTypes(CellType.SNAKE_BODY,
                    CellType.SNAKE_HEAD_DOWN, CellType.SNAKE_HEAD_LEFT, CellType.SNAKE_HEAD_RIGHT,
                    CellType.SNAKE_HEAD_UP));
            Collections.sort(snake.snakeBody);
            if (snake.snakeBody.isEmpty()) {
                Cell cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2 - 2];
                cageService.updateCellTypeAndIndex(cell, CellType.SNAKE_BODY, 0);
                snake.snakeBody.add(cell);

                cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2 - 1];
                cageService.updateCellTypeAndIndex(cell, CellType.SNAKE_BODY, 1);
                snake.snakeBody.add(cell);

                cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2];
                cageService.updateCellTypeAndIndex(cell, CellType.SNAKE_HEAD_RIGHT, 2);
                snake.snakeBody.add(cell);
            }
        }

        return snake;
    }

    public void drawSnake(AppCompatActivity appCompatActivity, Canvas canvas) {
        for (Cell cell : getSnake().snakeBody) {
            Drawable d = appCompatActivity.getResources().getDrawable(cell.getCellType().getResource(), null);
            d.setBounds(cell.getRect());
            d.draw(canvas);
        }
    }

    public Cell getSnakeHead() {
        return getSnake().snakeBody.get(getSnake().snakeBody.size() - 1);
    }

    public Cell getSnakeHeadAndTurnIntoBody() {
        Cell snakeHead = getSnakeHead();
        cageService.updateCellType(snakeHead, CellType.SNAKE_BODY);
        return snakeHead;

    }

    public void makeNewHead(int Y, int X, CellType cellType) {
        levelService.increaseMoveCount();
        Cell newHead = cageService.getCage().cells[Y][X];
        if (newHead.getCellType() == CellType.FOOD_MOVE_TO_NEXT_LEVEL) {
            levelService.loadNextLevel();
        }
        if (newHead.getCellType() != CellType.FOOD && newHead.getCellType() != CellType.FOOD_MOVE_TO_NEXT_LEVEL) {
            cageService.updateCellType(getSnake().snakeBody.get(0), CellType.EMPTY);
            getSnake().snakeBody.remove(0);
        }

        getSnake().snakeBody.add(newHead);
        cageService.updateCellType(newHead, cellType);
        for (int i = 0; i < getSnake().snakeBody.size(); i++) {
            cageService.updateCellIndex(getSnake().snakeBody.get(i), i);
        }
        board.clearAndDraw();
    }
}
