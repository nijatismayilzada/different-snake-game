package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.clicklistener.gamebuttons.LoadSaveOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.MenuButtonOCL;
import com.thepot.differentsnakegame.repository.CellRepository;
import com.thepot.differentsnakegame.repository.DatabaseDetails;
import com.thepot.differentsnakegame.repository.LevelRepository;
import com.thepot.differentsnakegame.runnable.HideSaveRunnable;
import com.thepot.differentsnakegame.runnable.SaveRunnable;
import com.thepot.differentsnakegame.runnable.ShowSaveRunnable;
import com.thepot.differentsnakegame.service.AdsService;
import com.thepot.differentsnakegame.service.BorderService;
import com.thepot.differentsnakegame.service.ButtonService;
import com.thepot.differentsnakegame.service.CageService;
import com.thepot.differentsnakegame.service.LevelService;
import com.thepot.differentsnakegame.service.SnakeService;

import java.util.Locale;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Board {
    private int mColorBackground;
    private Bitmap mBitmap;
    private ImageView boardHolder;
    private AppCompatActivity activity;
    private LevelService levelService;
    private TextView levelHolderText;
    private TextView movesHolderText;
    private TextView movesHolderView;
    private TextView gameState;
    private SnakeService snakeService;
    private BorderService borderService;
    private ButtonService buttonService;
    private CageService cageService;
    private ShowSaveRunnable showSaveRunnable;
    private HideSaveRunnable hideSaveRunnable;


    public Board(AppCompatActivity context, ImageView boardHolder) {
        activity = context;
        mBitmap = Bitmap.createBitmap(boardHolder.getMeasuredWidth(), boardHolder.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.boardHolder = boardHolder;
        this.boardHolder.setImageBitmap(mBitmap);

        mColorBackground = ResourcesCompat.getColor(activity.getResources(), R.color.colorBackgroundBlack, null);

        movesHolderText = activity.findViewById(R.id.movesHolder);
        movesHolderView = activity.findViewById(R.id.moves);
        levelHolderText = activity.findViewById(R.id.levelHolder);
        gameState = activity.findViewById(R.id.gameStateText);

        initialiseServices(activity, boardHolder);
        clearAndDraw();
    }

    private void initialiseServices(AppCompatActivity appCompatActivity, ImageView boardHolder) {
        DatabaseDetails databaseDetails = new DatabaseDetails(appCompatActivity);
        CellRepository cellRepository = new CellRepository(databaseDetails);
        cageService = new CageService(cellRepository, boardHolder);
        LevelRepository levelRepository = new LevelRepository(databaseDetails);
        levelService = new LevelService(appCompatActivity, cageService, levelRepository);
        snakeService = new SnakeService(appCompatActivity, cageService, levelService, this, new SaveRunnable(this));
        borderService = new BorderService(appCompatActivity, cageService, levelService);
        AdsService adsService = new AdsService(activity, this);
        new MenuButtonOCL(activity);
        LoadSaveOCL loadSaveOCL = new LoadSaveOCL(activity, this, adsService, levelService);
        showSaveRunnable = new ShowSaveRunnable(loadSaveOCL);
        hideSaveRunnable = new HideSaveRunnable(loadSaveOCL);
        buttonService = new ButtonService(activity, cageService, snakeService, levelService);
    }

    public void clearAndDraw() {
        Canvas canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        borderService.drawBorder(canvas);
        snakeService.drawSnake(canvas);
        levelService.drawLevel(canvas);
        buttonService.updateButtons();

        if (levelService.getCurrentLevel().getMovesLeft() < 0) {
            movesHolderView.setVisibility(INVISIBLE);
            movesHolderText.setVisibility(INVISIBLE);
        } else {
            movesHolderView.setVisibility(VISIBLE);
            movesHolderText.setVisibility(VISIBLE);
            movesHolderText.setText(String.valueOf(levelService.getCurrentLevel().getMovesLeft()));
        }

        levelHolderText.setText(doubleToString(levelService.getCurrentLevel().getCurrentLevel()));

        boardHolder.invalidate();
    }

    public void loadSave() {
        gameState.setVisibility(INVISIBLE);
        cageService.loadSavedCage();
        levelService.loadLevelSave();
        snakeService.getSnake(true);
        clearAndDraw();
    }

    public void saveGame() {
        activity.runOnUiThread(hideSaveRunnable);

        levelService.saveCurrentLevel();
        cageService.saveCage();

        activity.runOnUiThread(showSaveRunnable);
    }

    private String doubleToString(double d) {
        if (d == (long) d)
            return String.format(Locale.getDefault(), "%d", (long) d);
        else
            return String.format(Locale.getDefault(), "%s", d);
    }

}
