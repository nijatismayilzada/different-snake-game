package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;
import com.thepot.differentsnakegame.runnable.SaveRunnable;

import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.thepot.differentsnakegame.model.CellType.EMPTY;
import static com.thepot.differentsnakegame.model.CellType.FLARE;
import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.OBSTACLE;
import static com.thepot.differentsnakegame.model.CellType.SNAKE_BODY;
import static com.thepot.differentsnakegame.model.CellType.SNAKE_HEAD_DOWN;
import static com.thepot.differentsnakegame.model.CellType.SNAKE_HEAD_LEFT;
import static com.thepot.differentsnakegame.model.CellType.SNAKE_HEAD_RIGHT;
import static com.thepot.differentsnakegame.model.CellType.SNAKE_HEAD_UP;
import static com.thepot.differentsnakegame.service.CageService.CELL_COUNT;

public class SnakeService {
    private AppCompatActivity appCompatActivity;
    private CageService cageService;
    private LevelService levelService;
    private Board board;
    private SaveRunnable saveRunnable;
    private ThreadPoolExecutor threadPoolExecutor;


    private Snake snake;

    public SnakeService(AppCompatActivity appCompatActivity, CageService cageService, LevelService levelService, Board board, SaveRunnable saveRunnable) {
        this.appCompatActivity = appCompatActivity;
        this.cageService = cageService;
        this.levelService = levelService;
        this.board = board;
        this.saveRunnable = saveRunnable;
        threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public Snake getSnake() {
        return getSnake(false);
    }

    public Snake getSnake(boolean refreshSnake) {

        if (snake == null || refreshSnake) {
            snake = new Snake();
            snake.snakeBody.addAll(cageService.findCellsOfTypes(SNAKE_BODY,
                    SNAKE_HEAD_DOWN, SNAKE_HEAD_LEFT, SNAKE_HEAD_RIGHT,
                    SNAKE_HEAD_UP));
            Collections.sort(snake.snakeBody);
            if (snake.snakeBody.isEmpty()) {
                Cell cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2 - 5];
                cageService.updateCellTypeAndIndex(cell, SNAKE_BODY, 0);
                snake.snakeBody.add(cell);

                cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2 - 4];
                cageService.updateCellTypeAndIndex(cell, SNAKE_BODY, 1);
                snake.snakeBody.add(cell);

                cell = cageService.getCage().cells[CELL_COUNT / 2][CELL_COUNT / 2 - 3];
                cageService.updateCellTypeAndIndex(cell, SNAKE_HEAD_RIGHT, 2);
                snake.snakeBody.add(cell);
            }
        }

        return snake;
    }

    public void drawSnake(Canvas canvas) {
        for (Cell cell : getSnake().snakeBody) {
            int resource = cell.getCellType().getResource();
            if (resource != 0) {
                Drawable d = appCompatActivity.getResources().getDrawable(resource, null);
                d.setBounds(cell.getRect());
                d.draw(canvas);
            }
        }
    }

    public Cell getSnakeHead() {
        return getSnake().snakeBody.get(getSnake().snakeBody.size() - 1);
    }

    public Cell getSnakeHeadAndTurnIntoBody() {
        Cell snakeHead = getSnakeHead();
        cageService.updateCellType(snakeHead, SNAKE_BODY);
        return snakeHead;

    }

    public void makeNewHead(int Y, int X, int YAhead, int XAhead, CellType cellType) {

        levelService.updateMoveCount(levelService.getCurrentLevel().getMovesLeft() - 1);
        Cell newHead = cageService.getCage().cells[Y][X];

        switch (newHead.getCellType()) {
            case FOOD_MOVE_TO_NEXT_LEVEL:
                levelService.loadNextLevel();
                addHead(cellType, newHead);
                break;
            case FLARE:
                while (getSnake().snakeBody.size() != 6) {
                    removeTail();
                }
                levelService.loadNextLevel();
                addHead(cellType, newHead);
                break;
            case FOOD:
                if (cageService.findCellsOfTypes(FOOD, FLARE).size() == 1) {
                    levelService.loadNextLevel();
                }
                addHead(cellType, newHead);
                break;
            case POISON:
                while (getSnake().snakeBody.size() != 1) {
                    removeTail();
                }
                addHead(cellType, newHead);
                break;
            case OBSTACLE:
                levelService.addLevelCell(YAhead, XAhead, OBSTACLE);
                removeTail();
                addHead(cellType, newHead);
                break;
            case SAVE:
                removeTail();
                addHead(cellType, newHead);
                threadPoolExecutor.execute(saveRunnable);
                break;
            default:
                removeTail();
                addHead(cellType, newHead);
                break;
        }
        board.clearAndDraw();
    }

    private void addHead(CellType cellType, Cell newHead) {
        getSnake().snakeBody.add(newHead);
        cageService.updateCellType(newHead, cellType);
        for (int i = 0; i < getSnake().snakeBody.size(); i++) {
            cageService.updateCellIndex(getSnake().snakeBody.get(i), i);
        }
    }

    private void removeTail() {
        cageService.updateCellType(getSnake().snakeBody.get(0), EMPTY);
        getSnake().snakeBody.remove(0);
    }
}
