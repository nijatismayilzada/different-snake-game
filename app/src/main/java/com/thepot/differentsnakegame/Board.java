package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.level.LevelHolder;
import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.Snake;

import static android.view.ViewTreeObserver.OnGlobalLayoutListener;
import static com.thepot.differentsnakegame.model.Cage.CELL_MAX_ID;
import static com.thepot.differentsnakegame.model.Cage.CELL_MIN_ID;

public class Board {
    private int mColorBackground;
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Paint boardPaint;
    private AppCompatActivity activity;
    private Snake snake;
    private Cage cage;
    private Rect border;
    private LevelHolder levelHolder;
    private TextView levelHolderText;
    private int width;
    private int height;
    private TextView movesHolderText;
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;


    public Board(AppCompatActivity context) {
        activity = context;

        mImageView = context.findViewById(R.id.boardHolder);
        mColorBackground = ResourcesCompat.getColor(activity.getResources(), R.color.colorBackground, null);

        upButton = activity.findViewById(R.id.upButton);
        downButton = activity.findViewById(R.id.downButton);
        leftButton = activity.findViewById(R.id.leftButton);
        rightButton = activity.findViewById(R.id.rightButton);
        movesHolderText = activity.findViewById(R.id.movesHolder);
        levelHolderText = activity.findViewById(R.id.levelHolder);

        boardPaint = new Paint();
        boardPaint.setStyle(Paint.Style.STROKE);
        boardPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBoardLine, null));
        final ViewTreeObserver observer = mImageView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {

                        if (width == 0) {
                            width = mImageView.getMeasuredWidth();
                            height = mImageView.getMeasuredHeight();

                            setup(width, height);
                        }
                    }
                });
    }

    private void setup(int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);

        cage = new Cage(width, height);
        levelHolder = new LevelHolder(cage);
        snake = new Snake(cage);

        Rect startRect = cage.cells[CELL_MIN_ID][CELL_MIN_ID].getRect();
        Rect endRect = cage.cells[CELL_MAX_ID][CELL_MAX_ID].getRect();
        border = new Rect(startRect.left, startRect.top, endRect.right, endRect.bottom);

        boardPaint.setStrokeWidth(cage.cellSize / 10);
        clearAndDraw();
    }

    public Snake getSnake() {
        return snake;
    }

    public Cage getCage() {
        return cage;
    }

    public LevelHolder getLevelHolder() {
        return levelHolder;
    }

    public void clearAndDraw() {

        Canvas canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        snake.drawSnake(activity, canvas);
        levelHolder.drawLevel(activity, canvas);
        canvas.drawRect(border, boardPaint);
        updateButtons();

        movesHolderText.setText(String.valueOf(levelHolder.getLevel().getMovesLeft()));

        levelHolderText.setText(String.valueOf(levelHolder.getActiveLevel()));

        mImageView.invalidate();
    }

    private void updateButtons() {

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
