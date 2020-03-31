package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.clicklistener.DownButtonOCL;
import com.thepot.differentsnakegame.clicklistener.LeftButtonOCL;
import com.thepot.differentsnakegame.clicklistener.RightButtonOCL;
import com.thepot.differentsnakegame.clicklistener.UpButtonOCL;
import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.Snake;

import static com.thepot.differentsnakegame.model.Cage.CELL_MAX_ID;

public class ButtonService {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;

    private Cage cage;
    private Snake snake;
    private LevelHolder levelHolder;

    public ButtonService(AppCompatActivity activity, MovingService movingService, Cage cage, Snake snake, LevelHolder levelHolder) {
        this.cage = cage;
        this.snake = snake;
        this.levelHolder = levelHolder;

        upButton = activity.findViewById(R.id.upButton);
        upButton.setOnClickListener(new UpButtonOCL(snake, movingService));
        downButton = activity.findViewById(R.id.downButton);
        downButton.setOnClickListener(new DownButtonOCL(snake, movingService));
        leftButton = activity.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new LeftButtonOCL(snake, movingService));
        rightButton = activity.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new RightButtonOCL(snake, movingService));
    }

    public void updateButtons() {

        upButton.setClickable(true);
        downButton.setClickable(true);
        leftButton.setClickable(true);
        rightButton.setClickable(true);

        Cell snakeHead = snake.getSnakeHead();

        if (snakeHead.getY() - 1 < 0 || cage.cells[snakeHead.getY() - 1][snakeHead.getX()].getCellType().isNotActionable() || levelHolder.getLevel().noMovesLeft()) {
            upButton.setClickable(false);
        }
        if (snakeHead.getY() + 1 > CELL_MAX_ID || cage.cells[snakeHead.getY() + 1][snakeHead.getX()].getCellType().isNotActionable() || levelHolder.getLevel().noMovesLeft()) {
            downButton.setClickable(false);
        }
        if (snakeHead.getX() - 1 < 0 || cage.cells[snakeHead.getY()][snakeHead.getX() - 1].getCellType().isNotActionable() || levelHolder.getLevel().noMovesLeft()) {
            leftButton.setClickable(false);
        }
        if (snakeHead.getX() + 1 > CELL_MAX_ID || cage.cells[snakeHead.getY()][snakeHead.getX() + 1].getCellType().isNotActionable() || levelHolder.getLevel().noMovesLeft()) {
            rightButton.setClickable(false);
        }
    }
}
