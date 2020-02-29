package com.thepot.differentsnakegame;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

public class MainActivity extends AppCompatActivity {

    private Board board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        board = new Board(this);


    }


    public void moveUp(View view) {
        Cell snakeHead = board.getSnake().getSnakeHead();
        snakeHead.setCellType(CellType.SNAKE_BODY);

        Cell newHead = board.getCage().cells[snakeHead.getY() - 1][snakeHead.getX()];
        newHead.setCellType(CellType.SNAKE_HEAD_UP);
        board.getSnake().addCellAndRemoveTail(newHead);

        board.clearAndDraw();
    }

    public void moveDown(View view) {
        Cell snakeHead = board.getSnake().getSnakeHead();
        snakeHead.setCellType(CellType.SNAKE_BODY);

        Cell newHead = board.getCage().cells[snakeHead.getY() + 1][snakeHead.getX()];
        newHead.setCellType(CellType.SNAKE_HEAD_DOWN);
        board.getSnake().addCellAndRemoveTail(newHead);

        board.clearAndDraw();
    }

    public void moveLeft(View view) {
        Cell snakeHead = board.getSnake().getSnakeHead();
        snakeHead.setCellType(CellType.SNAKE_BODY);

        Cell newHead = board.getCage().cells[snakeHead.getY()][snakeHead.getX() - 1];
        newHead.setCellType(CellType.SNAKE_HEAD_LEFT);
        board.getSnake().addCellAndRemoveTail(newHead);

        board.clearAndDraw();
    }

    public void moveRight(View view) {
        Cell snakeHead = board.getSnake().getSnakeHead();
        snakeHead.setCellType(CellType.SNAKE_BODY);

        Cell newHead = board.getCage().cells[snakeHead.getY()][snakeHead.getX() + 1];
        newHead.setCellType(CellType.SNAKE_HEAD_RIGHT);
        board.getSnake().addCellAndRemoveTail(newHead);

        board.clearAndDraw();
    }


}
