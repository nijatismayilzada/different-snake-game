package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.model.Cage;
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


    public Board(AppCompatActivity context) {
        activity = context;

        mImageView = context.findViewById(R.id.boardHolder);

        final ViewTreeObserver observer = mImageView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mColorBackground = ResourcesCompat.getColor(activity.getResources(), R.color.colorBackground, null);

                        int width = mImageView.getMeasuredWidth();
                        int height = mImageView.getMeasuredHeight();

                        cage = new Cage(width, height);
                        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        mImageView.setImageBitmap(mBitmap);

                        snake = new Snake(cage);
                        boardPaint = new Paint();
                        boardPaint.setStyle(Paint.Style.STROKE);
                        boardPaint.setStrokeWidth(cage.cellSize / 10);
                        boardPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBoardLine, null));
                        Rect startRect = cage.cells[CELL_MIN_ID][CELL_MIN_ID].getRect();
                        Rect endRect = cage.cells[CELL_MAX_ID][CELL_MAX_ID].getRect();
                        border = new Rect(startRect.left, startRect.top, endRect.right, endRect.bottom);
                        clearAndDraw();
                    }
                });
    }

    public Snake getSnake() {
        return snake;
    }

    public Cage getCage() {
        return cage;
    }

    public void clearAndDraw() {
        Canvas canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        snake.drawSnake(activity, canvas);
        canvas.drawRect(border, boardPaint);
        mImageView.invalidate();
    }


}
