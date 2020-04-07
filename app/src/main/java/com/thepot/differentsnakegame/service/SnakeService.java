package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Snake;

import java.util.ArrayList;
import java.util.List;

import static com.thepot.differentsnakegame.model.Cage.CELL_COUNT;

public class SnakeService {
    private CageService cageService;


    private Snake snake;

    @Deprecated
    private List<Cell> snakeBody;


    public SnakeService(Cage cage) {

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

    public Snake getSnake() {

        if (snake == null) {
            snake = new Snake();
            snake.snakeBody.addAll(cageService.findCellsOfTypes(CellType.SNAKE_BODY));


        }

        return snake;
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
