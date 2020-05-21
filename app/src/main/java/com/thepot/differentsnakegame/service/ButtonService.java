package com.thepot.differentsnakegame.service;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.Board;
import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.DownButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.LeftButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.LoadSaveOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.MenuButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.RightButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.UpButtonOCL;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.thepot.differentsnakegame.model.CellType.EMPTY;
import static com.thepot.differentsnakegame.model.CellType.OBSTACLE;
import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;
import static com.thepot.differentsnakegame.service.LevelService.END_GAME;

public class ButtonService {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private ImageButton loadSaveButton;
    private TextView gameState;

    private CageService cageService;
    private SnakeService snakeService;
    private LevelService levelService;
    private AppCompatActivity activity;

    public ButtonService(AppCompatActivity activity, CageService cageService, SnakeService snakeService, LevelService levelService, Board board, AdsService adsService) {
        this.cageService = cageService;
        this.snakeService = snakeService;
        this.levelService = levelService;
        this.activity = activity;

        upButton = activity.findViewById(R.id.upButton);
        upButton.setOnClickListener(new UpButtonOCL(snakeService));
        downButton = activity.findViewById(R.id.downButton);
        downButton.setOnClickListener(new DownButtonOCL(snakeService));
        leftButton = activity.findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new LeftButtonOCL(snakeService));
        rightButton = activity.findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new RightButtonOCL(snakeService));
        loadSaveButton = activity.findViewById(R.id.loadSave);
        loadSaveButton.setOnClickListener(new LoadSaveOCL(board, adsService));
        showLoadSaveButton(levelService.gameSaveExists());


        activity.findViewById(R.id.menu).setOnClickListener(new MenuButtonOCL(activity));
        gameState = activity.findViewById(R.id.gameStateText);
        gameState.setVisibility(View.INVISIBLE);
    }


    public void showLoadSaveButton(boolean show) {
        if (show) {
            loadSaveButton.setVisibility(VISIBLE);
        } else {
            loadSaveButton.setVisibility(GONE);
        }
    }

    public void clickableLoadSaveButton(boolean show) {
        loadSaveButton.setClickable(show);
    }

    public void updateButtons() {

        upButton.setClickable(true);
        downButton.setClickable(true);
        leftButton.setClickable(true);
        rightButton.setClickable(true);
        upButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));
        downButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));
        leftButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));
        rightButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp));


        Cell snakeHead = snakeService.getSnakeHead();

        int yUp = checkEdge(snakeHead.getY() - 1 < CELL_MIN_ID, snakeHead.getY() - 1, CELL_MAX_ID);
        int yUp2 = checkEdge(yUp - 1 < CELL_MIN_ID, yUp - 1, CELL_MAX_ID);

        if (levelService.getCurrentLevel().getMovesLeft() == 0
                || cantGoUp(yUp)
                || (getCellType(yUp, snakeHead.getX()) == OBSTACLE && cantMoveUp(yUp2))) {
            upButton.setClickable(false);
            upButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_gray_24dp));
        }


        int yBottom = checkEdge(snakeHead.getY() + 1 > CELL_MAX_ID, snakeHead.getY() + 1, CELL_MIN_ID);
        int yBottom2 = checkEdge(yBottom + 1 > CELL_MAX_ID, yBottom + 1, CELL_MIN_ID);

        if (levelService.getCurrentLevel().getMovesLeft() == 0
                || cantGoDown(yBottom)
                || (getCellType(yBottom, snakeHead.getX()) == OBSTACLE && cantMoveDown(yBottom2))) {
            downButton.setClickable(false);
            downButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_gray_24dp));
        }


        int xLeft = checkEdge(snakeHead.getX() - 1 < CELL_MIN_ID, snakeHead.getX() - 1, CELL_MAX_ID);
        int xLeft2 = checkEdge(xLeft - 1 < CELL_MIN_ID, xLeft - 1, CELL_MAX_ID);

        if (levelService.getCurrentLevel().getMovesLeft() == 0
                || cantGoLeft(xLeft)
                || (getCellType(snakeHead.getY(), xLeft) == OBSTACLE && cantMoveLeft(xLeft2))) {
            leftButton.setClickable(false);
            leftButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_gray_24dp));
        }

        int xRight = checkEdge(snakeHead.getX() + 1 > CELL_MAX_ID, snakeHead.getX() + 1, CELL_MIN_ID);
        int xRight2 = checkEdge(xRight + 1 > CELL_MAX_ID, xRight + 1, CELL_MIN_ID);

        if (levelService.getCurrentLevel().getMovesLeft() == 0
                || cantGoRight(xRight)
                || (getCellType(snakeHead.getY(), xRight) == OBSTACLE && cantMoveRight(xRight2))) {
            rightButton.setClickable(false);
            rightButton.setBackground(activity.getDrawable(R.drawable.ic_keyboard_arrow_down_gray_24dp));
        }

        if (!upButton.isClickable() && !downButton.isClickable() && !leftButton.isClickable() && !rightButton.isClickable()) {
            gameState.setText(R.string.game_over);
            gameState.setVisibility(VISIBLE);
        }

        if (levelService.getCurrentLevel().getCurrentLevel() == END_GAME) {
            gameState.setText(R.string.game_end);
            gameState.setVisibility(VISIBLE);
        }
    }

    private int checkEdge(boolean endOfEdge, int coordinate, int replacementCoordinate) {
        if (endOfEdge && levelService.getCurrentLevel().isTransparentWall()) {
            return replacementCoordinate;
        }
        return coordinate;
    }

    private boolean cantGoUp(int yUp) {
        return yUp < CELL_MIN_ID || getCellType(yUp, snakeService.getSnakeHead().getX()).isNotActionable();
    }

    private boolean cantMoveUp(int yUp) {
        return yUp < CELL_MIN_ID || getCellType(yUp, snakeService.getSnakeHead().getX()) != EMPTY;
    }

    private boolean cantGoDown(int yBottom) {
        return yBottom > CELL_MAX_ID || getCellType(yBottom, snakeService.getSnakeHead().getX()).isNotActionable();
    }

    private boolean cantMoveDown(int yBottom) {
        return yBottom > CELL_MAX_ID || getCellType(yBottom, snakeService.getSnakeHead().getX()) != EMPTY;
    }

    private boolean cantGoLeft(int xLeft) {
        return xLeft < CELL_MIN_ID || getCellType(snakeService.getSnakeHead().getY(), xLeft).isNotActionable();
    }

    private boolean cantMoveLeft(int xLeft) {
        return xLeft < CELL_MIN_ID || getCellType(snakeService.getSnakeHead().getY(), xLeft) != EMPTY;
    }

    private boolean cantGoRight(int xRight) {
        return xRight > CELL_MAX_ID || getCellType(snakeService.getSnakeHead().getY(), xRight).isNotActionable();
    }

    private boolean cantMoveRight(int xRight) {
        return xRight > CELL_MAX_ID || getCellType(snakeService.getSnakeHead().getY(), xRight) != EMPTY;
    }

    private CellType getCellType(int y, int x) {
        return cageService.getCage().cells[y][x].getCellType();
    }

}
