package com.thepot.differentsnakegame.service;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.DownButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.LeftButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.RightButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.UpButtonOCL;
import com.thepot.differentsnakegame.model.Cell;

import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;

public class ButtonService {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private TextView gameOver;

    private CageService cageService;
    private SnakeService snakeService;
    private LevelService levelService;

    public ButtonService(AppCompatActivity activity, CageService cageService, SnakeService snakeService, LevelService levelService) {
        this.cageService = cageService;
        this.snakeService = snakeService;
        this.levelService = levelService;

        upButton = activity.findViewById(R.id.upButton);
        upButton.setOnClickListener(new UpButtonOCL(snakeService));
        downButton = activity.findViewById(R.id.downButton);
        downButton.setOnClickListener(new DownButtonOCL(snakeService));
        leftButton = activity.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new LeftButtonOCL(snakeService));
        rightButton = activity.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new RightButtonOCL(snakeService));

        gameOver = activity.findViewById(R.id.gameOver);
    }

    public void updateButtons() {

        upButton.setClickable(true);
        downButton.setClickable(true);
        leftButton.setClickable(true);
        rightButton.setClickable(true);

        Cell snakeHead = snakeService.getSnakeHead();

        if (snakeHead.getY() - 1 < 0 || cageService.getCage().cells[snakeHead.getY() - 1][snakeHead.getX()].getCellType().isNotActionable() || levelService.noMovesLeft()) {
            upButton.setClickable(false);
        }
        if (snakeHead.getY() + 1 > CELL_MAX_ID || cageService.getCage().cells[snakeHead.getY() + 1][snakeHead.getX()].getCellType().isNotActionable() || levelService.noMovesLeft()) {
            downButton.setClickable(false);
        }
        if (snakeHead.getX() - 1 < 0 || cageService.getCage().cells[snakeHead.getY()][snakeHead.getX() - 1].getCellType().isNotActionable() || levelService.noMovesLeft()) {
            leftButton.setClickable(false);
        }
        if (snakeHead.getX() + 1 > CELL_MAX_ID || cageService.getCage().cells[snakeHead.getY()][snakeHead.getX() + 1].getCellType().isNotActionable() || levelService.noMovesLeft()) {
            rightButton.setClickable(false);
        }

        if (upButton.isClickable() || downButton.isClickable() || leftButton.isClickable() || rightButton.isClickable()) {
            gameOver.setVisibility(View.INVISIBLE);
        } else {
            gameOver.setVisibility(View.VISIBLE);
        }
    }
}
