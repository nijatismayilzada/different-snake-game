package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.R;

import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class BorderService {
    private AppCompatActivity activity;
    private CageService cageService;

    // cache
    private Paint borderPaint;
    private Rect border;
    //

    public BorderService(AppCompatActivity activity, CageService cageService) {
        this.activity = activity;
        this.cageService = cageService;
    }

    public void drawBorder(Canvas canvas) {
        if (borderPaint == null || border == null) {
            borderPaint = new Paint();
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBoardLine, null));
            borderPaint.setStrokeWidth(cageService.getCellSize() / 10);

            Rect startRect = cageService.getCage().cells[CELL_MIN_ID][CELL_MIN_ID].getRect();
            Rect endRect = cageService.getCage().cells[CELL_MAX_ID][CELL_MAX_ID].getRect();
            border = new Rect(startRect.left, startRect.top, endRect.right, endRect.bottom);
        }

        canvas.drawRect(border, borderPaint);
    }
}
