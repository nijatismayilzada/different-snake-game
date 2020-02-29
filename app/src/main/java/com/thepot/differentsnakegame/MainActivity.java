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
        makeNewHead(board.getSnake().getSnakeHeadAndTurnIntoBody().getY() - 1,
                board.getSnake().getSnakeHeadAndTurnIntoBody().getX(), CellType.SNAKE_HEAD_UP);
    }

    public void moveDown(View view) {
        makeNewHead(board.getSnake().getSnakeHeadAndTurnIntoBody().getY() + 1,
                board.getSnake().getSnakeHeadAndTurnIntoBody().getX(), CellType.SNAKE_HEAD_DOWN);
    }

    public void moveLeft(View view) {
        makeNewHead(board.getSnake().getSnakeHeadAndTurnIntoBody().getY(),
                board.getSnake().getSnakeHeadAndTurnIntoBody().getX() - 1, CellType.SNAKE_HEAD_LEFT);
    }

    public void moveRight(View view) {
        makeNewHead(board.getSnake().getSnakeHeadAndTurnIntoBody().getY(),
                board.getSnake().getSnakeHeadAndTurnIntoBody().getX() + 1, CellType.SNAKE_HEAD_RIGHT);
    }

    private void makeNewHead(int Y, int X, CellType cellType) {
        board.getLevelHolder().getLevel().increaseMoveCount();
        Cell newHead = board.getCage().cells[Y][X];
        if (newHead.isMoveToNextLevel()) {
            board.getLevelHolder().loadNextLevel();
            newHead.setMoveToNextLevel(false);
        }
        board.getSnake().addCell(newHead);
        newHead.setCellType(cellType);

        board.clearAndDraw();
    }


}
