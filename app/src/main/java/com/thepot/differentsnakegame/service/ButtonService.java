package com.thepot.differentsnakegame.service;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.DownButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.LeftButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.RightButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.UpButtonOCL;
import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;

import static com.thepot.differentsnakegame.model.Cage.CELL_MAX_ID;

public class ButtonService {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;

    private Cage cage;
    private SnakeService snakeService;
    private LevelHolder levelHolder;

    public ButtonService(AppCompatActivity activity, MovingService movingService, Cage cage, SnakeService snakeService, LevelHolder levelHolder) {
        this.cage = cage;
        this.snakeService = snakeService;
        this.levelHolder = levelHolder;

        upButton = activity.findViewById(R.id.upButton);
        upButton.setOnClickListener(new UpButtonOCL(snakeService, movingService));
        downButton = activity.findViewById(R.id.downButton);
        downButton.setOnClickListener(new DownButtonOCL(snakeService, movingService));
        leftButton = activity.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new LeftButtonOCL(snakeService, movingService));
        rightButton = activity.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new RightButtonOCL(snakeService, movingService));
    }

    public void updateButtons() {

        upButton.setClickable(true);
        downButton.setClickable(true);
        leftButton.setClickable(true);
        rightButton.setClickable(true);

        Cell snakeHead = snakeService.getSnakeHead();

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
