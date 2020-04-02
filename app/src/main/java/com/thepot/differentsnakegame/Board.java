package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.clicklistener.gamebuttons.MenuButtonOCL;
import com.thepot.differentsnakegame.clicklistener.gamebuttons.ReplayButtonOCL;
import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Snake;
import com.thepot.differentsnakegame.service.BorderService;
import com.thepot.differentsnakegame.service.ButtonService;
import com.thepot.differentsnakegame.service.MovingService;

public class Board {
    private int mColorBackground;
    private Bitmap mBitmap;
    private ImageView boardHolder;
    private AppCompatActivity activity;
    private LevelHolder levelHolder;
    private TextView levelHolderText;
    private TextView movesHolderText;
    private Snake snake;
    private BorderService borderService;
    private ButtonService buttonService;
    private Cage cage;
    private MovingService movingService;


    public Board(AppCompatActivity context, ImageView boardHolder) {
        activity = context;
        mBitmap = Bitmap.createBitmap(boardHolder.getMeasuredWidth(), boardHolder.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.boardHolder = boardHolder;
        this.boardHolder.setImageBitmap(mBitmap);

        mColorBackground = ResourcesCompat.getColor(activity.getResources(), R.color.colorBackground, null);

        activity.<ImageButton>findViewById(R.id.menu).setOnClickListener(new MenuButtonOCL(activity));
        activity.<ImageButton>findViewById(R.id.replay).setOnClickListener(new ReplayButtonOCL(activity, boardHolder, this));

        movesHolderText = activity.findViewById(R.id.movesHolder);
        levelHolderText = activity.findViewById(R.id.levelHolder);

        initialiseServices(activity, boardHolder);
        clearAndDraw();
    }

    public void initialiseServices(AppCompatActivity context, ImageView boardHolder) {
        cage = new Cage(boardHolder.getMeasuredWidth(), boardHolder.getMeasuredHeight());
        levelHolder = new LevelHolder(cage);
        snake = new Snake(cage);
        movingService = new MovingService(levelHolder, cage, snake, this);
        borderService = new BorderService(context, cage);
        buttonService = new ButtonService(activity, movingService, cage, snake, levelHolder);
    }

    public void clearAndDraw() {
        Canvas canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        snake.drawSnake(activity, canvas);
        levelHolder.drawLevel(activity, canvas);
        borderService.drawBorder(canvas);
        buttonService.updateButtons();

        movesHolderText.setText(String.valueOf(levelHolder.getLevel().getMovesLeft()));
        levelHolderText.setText(String.valueOf(levelHolder.getActiveLevel()));

        boardHolder.invalidate();
    }

}
