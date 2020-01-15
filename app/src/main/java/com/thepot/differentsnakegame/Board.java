package com.thepot.differentsnakegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

import static android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class Board {
    private Canvas canvas;
    private Bitmap mBitmap;
    private Snake snake;


    private int mColorBackground;
    private int mColorBoardLine;
    private ImageView mImageView;
    private AppCompatActivity appCompatActivity;
    private int sS;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Board(AppCompatActivity context) {

        appCompatActivity = context;

        mImageView = context.findViewById(R.id.boardHolder);

        mColorBackground = ResourcesCompat.getColor(context.getResources(), R.color.colorBackground, null);
        mColorBoardLine = ResourcesCompat.getColor(context.getResources(), R.color.colorBoardLine, null);


        final ViewTreeObserver observer = mImageView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        int w = mImageView.getMeasuredWidth();
                        int h = mImageView.getMeasuredHeight();

                        int wS = w / 14;
                        int hS = h / 20;

                        sS = Math.min(wS, hS);

                        startX = (w - sS * 14) / 2;
                        startY = (h - sS * 20) / 2;
                        endX = w - (startX);
                        endY = h - startY;


                        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                        mImageView.setImageBitmap(mBitmap);
                        snake = new Snake(5, startX + sS * 7, startY + sS * 10, sS);
                        clearAndDraw();
                    }
                });
    }

    public Snake getSnake() {
        return snake;
    }


    public void clearAndDraw() {
        canvas = new Canvas(mBitmap);
        canvas.drawColor(mColorBackground);
        ArrayList<Rect> rects = snake.getRects();
        for (int i = 0; i < rects.size(); i++) {
            Rect s = rects.get(i);
            Drawable d;
            if (i != rects.size() - 1) {
                d = appCompatActivity.getResources().getDrawable(R.drawable.ic_add_box_24px, null);
            } else {
                d = appCompatActivity.getResources().getDrawable(snake.getSnakeHeadDirection().getResource(), null);
            }
            d.setBounds(s);
            d.draw(canvas);
        }

        Paint boardP = new Paint();
        boardP.setStyle(Paint.Style.STROKE);
        boardP.setStrokeWidth(sS / 10);
        boardP.setColor(mColorBoardLine);

        canvas.drawRect(new Rect(startX, startY, endX, endY), boardP);

        mImageView.invalidate();
    }


}
