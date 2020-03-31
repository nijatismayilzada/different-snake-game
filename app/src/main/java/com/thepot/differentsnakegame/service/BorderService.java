package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.R;
import com.thepot.differentsnakegame.model.Cage;

import static com.thepot.differentsnakegame.model.Cage.CELL_MAX_ID;
import static com.thepot.differentsnakegame.model.Cage.CELL_MIN_ID;

public class BorderService {
    private Paint borderPaint;
    private Rect border;

    public BorderService(AppCompatActivity activity, Cage cage) {
        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBoardLine, null));
        borderPaint.setStrokeWidth(cage.cellSize / 10);

        Rect startRect = cage.cells[CELL_MIN_ID][CELL_MIN_ID].getRect();
        Rect endRect = cage.cells[CELL_MAX_ID][CELL_MAX_ID].getRect();
        border = new Rect(startRect.left, startRect.top, endRect.right, endRect.bottom);
    }

    public void drawBorder(Canvas canvas) {
        canvas.drawRect(border, borderPaint);
    }
}
