package com.thepot.differentsnakegame.model;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static com.thepot.differentsnakegame.model.Cage.CELL_COUNT;

public class Snake {
    private List<Cell> snakeBody;

    public Snake(Cage cage) {

        snakeBody = new ArrayList<>();

        Cell cell = cage.cells[CELL_COUNT / 2][CELL_COUNT / 2 - 2];
        cell.setCellType(CellType.SNAKE_BODY);
        snakeBody.add(cell);

        cell = cage.cells[CELL_COUNT / 2][CELL_COUNT / 2 - 1];
        cell.setCellType(CellType.SNAKE_BODY);
        snakeBody.add(cell);

        cell = cage.cells[CELL_COUNT / 2][CELL_COUNT / 2];
        cell.setCellType(CellType.SNAKE_HEAD_RIGHT);
        snakeBody.add(cell);
    }

    public void drawSnake(AppCompatActivity appCompatActivity, Canvas canvas) {
        for (Cell cell : snakeBody) {
            Drawable d = appCompatActivity.getResources().getDrawable(cell.getCellType().getResource(), null);
            d.setBounds(cell.getRect());
            d.draw(canvas);
        }

    }

    public Cell getSnakeHead() {
        return snakeBody.get(snakeBody.size() - 1);
    }

    public Cell getSnakeHeadAndTurnIntoBody() {

        Cell snakeHead = getSnakeHead();
        snakeHead.setCellType(CellType.SNAKE_BODY);
        return snakeHead;

    }

    public void addCell(Cell cell) {
        snakeBody.add(cell);
        if (cell.getCellType() != CellType.FOOD) {
            snakeBody.get(0).setCellType(CellType.EMPTY);
            snakeBody.remove(0);
        }

    }

}
