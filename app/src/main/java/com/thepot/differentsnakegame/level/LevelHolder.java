package com.thepot.differentsnakegame.level;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cage;
import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;

public class LevelHolder {

    private Level level;
    private Cage cage;
    private int activeLevel;

    public LevelHolder(Cage cage) {
        this.cage = cage;
        this.activeLevel = 1;
        loadLevel();
    }

    public int getActiveLevel() {
        return activeLevel;
    }

    public void loadNextLevel() {
        activeLevel++;
        loadLevel();
    }

    private void loadLevel() {
        switch (activeLevel) {
            case 1:
                loadFirstLevel();
                break;
            case 2:
                loadSecondLevel();
                break;
            default:
                loadFirstLevel();
                break;


        }


    }


    private void loadFirstLevel() {

        level = new Level(3);

        Cell food = cage.cells[10][13];
        food.setCellType(CellType.FOOD);
        food.setMoveToNextLevel(true);
        level.getFoods().add(food);


    }

    private void loadSecondLevel() {

        level = new Level(7);

        Cell food = cage.cells[3][13];
        food.setCellType(CellType.FOOD);
        food.setMoveToNextLevel(true);
        level.getFoods().add(food);


    }

    public Level getLevel() {
        return level;
    }

    public void drawLevel(AppCompatActivity appCompatActivity, Canvas canvas) {

        if (level != null) {
            for (Cell cell : level.getFoods()) {
                drawCell(appCompatActivity, canvas, cell);
            }
            for (Cell cell : level.getWalls()) {
                drawCell(appCompatActivity, canvas, cell);
            }
        }

    }

    private void drawCell(AppCompatActivity appCompatActivity, Canvas canvas, Cell cell) {
        Drawable d = appCompatActivity.getResources().getDrawable(cell.getCellType().getResource(), null);
        d.setBounds(cell.getRect());
        d.draw(canvas);
    }

}
