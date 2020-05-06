package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thepot.differentsnakegame.R;

import static android.graphics.Paint.Style.FILL;
import static android.graphics.Paint.Style.STROKE;
import static com.thepot.differentsnakegame.service.CageService.CELL_MAX_ID;
import static com.thepot.differentsnakegame.service.CageService.CELL_MIN_ID;

public class BorderService {
    private AppCompatActivity activity;
    private CageService cageService;
    private LevelService levelService;

    // cache
    private Paint borderPaint;
    private Rect border;
    private Paint backgroundPaint;
    //

    public BorderService(AppCompatActivity activity, CageService cageService, LevelService levelService) {
        this.activity = activity;
        this.cageService = cageService;
        this.levelService = levelService;
    }

    public void drawBorder(Canvas canvas) {
        if (backgroundPaint == null || borderPaint == null || border == null) {
            backgroundPaint = new Paint();
            backgroundPaint.setStyle(FILL);
            backgroundPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBackground, null));

            borderPaint = new Paint();
            borderPaint.setStyle(STROKE);
            borderPaint.setColor(ResourcesCompat.getColor(activity.getResources(), R.color.colorBoardLine, null));
            borderPaint.setStrokeWidth(cageService.getCellSize() / 4);

            Rect startRect = cageService.getCage().cells[CELL_MIN_ID][CELL_MIN_ID].getRect();
            Rect endRect = cageService.getCage().cells[CELL_MAX_ID][CELL_MAX_ID].getRect();
            border = new Rect(startRect.left, startRect.top, endRect.right, endRect.bottom);
        }

        canvas.drawRect(border, backgroundPaint);

        if (!levelService.getCurrentLevel().isTransparentWall()) {
            canvas.drawRect(border, borderPaint);
        }
    }
}
