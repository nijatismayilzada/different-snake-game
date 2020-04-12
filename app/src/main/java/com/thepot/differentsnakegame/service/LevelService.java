package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Challenge;
import com.thepot.differentsnakegame.model.CurrentLevel;
import com.thepot.differentsnakegame.repository.LevelRepository;

public class LevelService {

    private CageService cageService;
    private LevelRepository levelRepository;

    // cahing
    private Challenge challenge;
    private CurrentLevel currentLevel;

    public LevelService(CageService cageService, LevelRepository levelRepository) {
        this.cageService = cageService;
        this.levelRepository = levelRepository;
    }

    public boolean noMovesLeft() {
        if (getCurrentLevel().getMovesLeft() <= 0) {
            return true;
        }
        return false;
    }

    public void increaseMoveCount() {
        getCurrentLevel().setMovesLeft(getCurrentLevel().getMovesLeft() - 1);
        levelRepository.updateCurrentLevel(currentLevel);
    }

    public CurrentLevel getCurrentLevel() {
        if (currentLevel == null) {
            currentLevel = levelRepository.getCurrentLevelDetails();
            if (currentLevel == null) {
                loadFirstLevel();
            } else {
                challenge = new Challenge();
                challenge.getFoods().addAll(cageService.findCellsOfTypes(CellType.FOOD, CellType.FOOD_MOVE_TO_NEXT_LEVEL));
                challenge.getWalls().addAll(cageService.findCellsOfTypes(CellType.WALL));
            }
        }

        return currentLevel;
    }

    public void loadNextLevel() {
        currentLevel.setCurrentLevel(currentLevel.getCurrentLevel() + 1);
        levelRepository.updateCurrentLevel(currentLevel);
        loadLevel();
    }

    private void loadLevel() {
        switch (currentLevel.getCurrentLevel()) {
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

        currentLevel = new CurrentLevel();
        currentLevel.setCurrentLevel(1);
        currentLevel.setMovesLeft(3);
        levelRepository.insertCurrentLevel(currentLevel);

        Cell food = cageService.getCage().cells[10][13];
        cageService.updateCellType(food, CellType.FOOD_MOVE_TO_NEXT_LEVEL);

        challenge = new Challenge();
        challenge.getFoods().add(food);

    }

    private void loadSecondLevel() {

        currentLevel = new CurrentLevel();
        currentLevel.setCurrentLevel(2);
        currentLevel.setMovesLeft(7);
        levelRepository.updateCurrentLevel(currentLevel);

        Cell food = cageService.getCage().cells[3][13];
        cageService.updateCellType(food, CellType.FOOD_MOVE_TO_NEXT_LEVEL);

        challenge = new Challenge();
        challenge.getFoods().add(food);


    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void drawLevel(AppCompatActivity appCompatActivity, Canvas canvas) {

        if (getCurrentLevel() != null) {
            for (Cell cell : getChallenge().getFoods()) {
                drawCell(appCompatActivity, canvas, cell);
            }
            for (Cell cell : getChallenge().getWalls()) {
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
