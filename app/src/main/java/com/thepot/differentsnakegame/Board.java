package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.clicklistener.gamebuttons.MenuButtonOCL;
import com.thepot.differentsnakegame.repository.CellRepository;
import com.thepot.differentsnakegame.repository.DatabaseDetails;
import com.thepot.differentsnakegame.repository.LevelRepository;
import com.thepot.differentsnakegame.service.BorderService;
import com.thepot.differentsnakegame.service.ButtonService;
import com.thepot.differentsnakegame.service.CageService;
import com.thepot.differentsnakegame.service.LevelService;
import com.thepot.differentsnakegame.service.SnakeService;

public class Board {
    private int mColorBackground;
    private Bitmap mBitmap;
    private ImageView boardHolder;
    private AppCompatActivity activity;
    private LevelService levelService;
    private TextView levelHolderText;
    private TextView movesHolderText;
    private SnakeService snakeService;
    private BorderService borderService;
    private ButtonService buttonService;


    public Board(AppCompatActivity context, ImageView boardHolder) {
        activity = context;
        mBitmap = Bitmap.createBitmap(boardHolder.getMeasuredWidth(), boardHolder.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.boardHolder = boardHolder;
        this.boardHolder.setImageBitmap(mBitmap);

        mColorBackground = ResourcesCompat.getColor(activity.getResources(), R.color.colorBackground, null);

        activity.<ImageButton>findViewById(R.id.menu).setOnClickListener(new MenuButtonOCL(activity));

        movesHolderText = activity.findViewById(R.id.movesHolder);
        levelHolderText = activity.findViewById(R.id.levelHolder);

        initialiseServices(activity, boardHolder);
        clearAndDraw();
    }

    public void initialiseServices(AppCompatActivity appCompatActivity, ImageView boardHolder) {
        DatabaseDetails databaseDetails = new DatabaseDetails(appCompatActivity);
        CellRepository cellRepository = new CellRepository(databaseDetails);
        CageService cageService = new CageService(cellRepository, boardHolder);
        LevelRepository levelRepository = new LevelRepository(databaseDetails);
        levelService = new LevelService(cageService, levelRepository);
        snakeService = new SnakeService(cageService, levelService, this);
        borderService = new BorderService(appCompatActivity, cageService);
        buttonService = new ButtonService(activity, cageService, snakeService, levelService);
    }

    public void clearAndDraw() {
        Canvas canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        snakeService.drawSnake(activity, canvas);
        levelService.drawLevel(activity, canvas);
        borderService.drawBorder(canvas);
        buttonService.updateButtons();

        movesHolderText.setText(String.valueOf(levelService.getCurrentLevel().getMovesLeft()));
        levelHolderText.setText(String.valueOf(levelService.getCurrentLevel().getCurrentLevel()));

        boardHolder.invalidate();
    }

}
