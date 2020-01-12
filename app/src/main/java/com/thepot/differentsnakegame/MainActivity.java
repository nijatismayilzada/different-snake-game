package com.thepot.differentsnakegame;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Board board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        board = new Board(this);


    }


    public void moveUp(View view) {
        Snake snake = board.getSnake();
        snake.setSnakeHeadDirection(SnakeHeadDirection.UP);
        Rect rect = snake.getHeadToMove();

        rect.set(rect.left, rect.top * 2 - rect.bottom, rect.right, rect.top);
        board.clearAndDraw();

    }

    public void moveDown(View view) {
        Snake snake = board.getSnake();
        snake.setSnakeHeadDirection(SnakeHeadDirection.DOWN);
        Rect rect = snake.getHeadToMove();
        rect.set(rect.left, rect.bottom, rect.right, rect.bottom * 2 - rect.top);
        board.clearAndDraw();
    }

    public void moveLeft(View view) {
        Snake snake = board.getSnake();
        snake.setSnakeHeadDirection(SnakeHeadDirection.LEFT);
        Rect rect = snake.getHeadToMove();
        rect.set(rect.left * 2 - rect.right, rect.top, rect.left, rect.bottom);

        board.clearAndDraw();
    }

    public void moveRight(View view) {
        Snake snake = board.getSnake();
        snake.setSnakeHeadDirection(SnakeHeadDirection.RIGHT);
        Rect rect = snake.getHeadToMove();
        rect.set(rect.right, rect.top, rect.right * 2 - rect.left, rect.bottom);
        board.clearAndDraw();
    }


}
