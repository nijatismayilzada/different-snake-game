package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Challenge;
import com.thepot.differentsnakegame.model.CurrentLevel;
import com.thepot.differentsnakegame.repository.LevelRepository;

import java.util.List;
import java.util.Random;

import static com.thepot.differentsnakegame.model.CellType.FOOD;
import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;
import static com.thepot.differentsnakegame.model.CellType.POISON;
import static com.thepot.differentsnakegame.model.CellType.WALL;

public class LevelService {
    private AppCompatActivity appCompatActivity;
    private CageService cageService;
    private LevelRepository levelRepository;

    // caching
    private Challenge challenge;
    private CurrentLevel currentLevel;

    public LevelService(AppCompatActivity appCompatActivity, CageService cageService, LevelRepository levelRepository) {
        this.appCompatActivity = appCompatActivity;
        this.cageService = cageService;
        this.levelRepository = levelRepository;
    }


    public void drawLevel(Canvas canvas) {
        if (getCurrentLevel() != null) {
            for (Cell cell : challenge.getLevelCells()) {
                Drawable d = appCompatActivity.getResources().getDrawable(cell.getCellType().getResource(), null);
                d.setBounds(cell.getRect());
                d.draw(canvas);
            }
        }
    }

    public boolean noMovesLeft() {
        return getCurrentLevel().getMovesLeft() == 0;
    }

    public void increaseMoveCount() {
        updateMoveCount(getCurrentLevel().getMovesLeft() - 1);
    }

    private void updateMoveCount(int moveCount) {
        getCurrentLevel().setMovesLeft(moveCount);
        levelRepository.updateCurrentLevel(getCurrentLevel());
    }

    private void addLevelCell(int y, int x, CellType foodMoveToNextLevel) {
        cageService.updateCellType(cageService.getCage().cells[y][x], foodMoveToNextLevel);
        challenge.getLevelCells().add(cageService.getCage().cells[y][x]);
    }

    public CurrentLevel getCurrentLevel() {
        if (currentLevel == null) {
            currentLevel = levelRepository.getCurrentLevelDetails();
            if (currentLevel == null) {
                currentLevel = new CurrentLevel();
                currentLevel.setCurrentLevel(1);
                currentLevel.setMovesLeft(0);
                levelRepository.insertCurrentLevel(currentLevel);
                loadFirstLevel();
            } else {
                challenge = new Challenge();
                challenge.getLevelCells().addAll(cageService.findCellsOfTypes(FOOD, FOOD_MOVE_TO_NEXT_LEVEL, WALL));
            }
        }

        return currentLevel;
    }

    public void loadNextLevel() {
        getCurrentLevel().setCurrentLevel(getCurrentLevel().getCurrentLevel() + 1);
        levelRepository.updateCurrentLevel(getCurrentLevel());
        cageService.clearCells(FOOD, FOOD_MOVE_TO_NEXT_LEVEL, WALL);
        switch (getCurrentLevel().getCurrentLevel()) {
            case 1:
                loadFirstLevel();
                break;
            case 2:
                loadSecondLevel();
                break;
            case 3:
                loadThirdLevel();
                break;
            case 4:
                loadFourthLevel();
                break;
            case 5:
                loadFifthLevel();
                break;
            case 6:
                loadSixthLevel();
                break;
            case 7:
                loadSeventhLevel();
                break;
            default:
                loadRandomFood();
                break;
        }

    }

    private void loadRandomFood() {

        updateMoveCount(-1);

        challenge = new Challenge();


        List<Cell> emptyCells = cageService.findCellsOfTypes(CellType.EMPTY);


        Cell cell = emptyCells.get(new Random().nextInt(emptyCells.size()));

        cageService.updateCellType(cell, FOOD_MOVE_TO_NEXT_LEVEL);
        challenge.getLevelCells().add(cell);

    }

    private void loadFirstLevel() {

        updateMoveCount(3);

        challenge = new Challenge();

        addLevelCell(7, 7, FOOD_MOVE_TO_NEXT_LEVEL);

    }

    private void loadSecondLevel() {

        updateMoveCount(12);

        challenge = new Challenge();

        addLevelCell(1, 1, FOOD_MOVE_TO_NEXT_LEVEL);

    }

    private void loadThirdLevel() {

        updateMoveCount(12);

        challenge = new Challenge();

        addLevelCell(3, 9, FOOD_MOVE_TO_NEXT_LEVEL);

        addLevelCell(1, 7, WALL);
        addLevelCell(1, 8, WALL);
        addLevelCell(2, 6, WALL);
        addLevelCell(2, 7, WALL);
        addLevelCell(3, 6, WALL);


    }

    private void loadFourthLevel() {

        updateMoveCount(12);

        challenge = new Challenge();

        addLevelCell(11, 7, FOOD_MOVE_TO_NEXT_LEVEL);
        addLevelCell(9, 7, WALL);
        addLevelCell(10, 8, WALL);
        addLevelCell(11, 9, WALL);


    }

    private void loadFifthLevel() {

        updateMoveCount(16);

        challenge = new Challenge();

        addLevelCell(10, 4, FOOD);
        addLevelCell(12, 3, FOOD);
        addLevelCell(14, 3, FOOD);
        addLevelCell(11, 3, WALL);
        addLevelCell(11, 4, WALL);
        addLevelCell(13, 3, WALL);
        addLevelCell(13, 4, WALL);


    }

    private void loadSixthLevel() {

        updateMoveCount(100);

        challenge = new Challenge();

        addLevelCell(2, 3, FOOD);
        addLevelCell(2, 11, FOOD);
        addLevelCell(2, 1, WALL);
        addLevelCell(1, 1, WALL);
        addLevelCell(1, 2, WALL);
        addLevelCell(1, 3, WALL);
        addLevelCell(1, 4, WALL);
        addLevelCell(2, 4, WALL);
        addLevelCell(3, 4, WALL);
        addLevelCell(4, 4, WALL);
        addLevelCell(4, 3, WALL);
        addLevelCell(4, 2, WALL);
        addLevelCell(4, 1, WALL);
        addLevelCell(1, 13, WALL);
        addLevelCell(1, 12, WALL);
        addLevelCell(1, 11, WALL);
        addLevelCell(1, 10, WALL);
        addLevelCell(2, 10, WALL);
        addLevelCell(3, 10, WALL);
        addLevelCell(4, 10, WALL);
        addLevelCell(4, 11, WALL);
        addLevelCell(4, 12, WALL);
        addLevelCell(4, 13, WALL);


    }

    private void loadSeventhLevel() {

        updateMoveCount(100);

        challenge = new Challenge();

        addLevelCell(11, 3, FOOD);
        addLevelCell(11, 11, FOOD);
        addLevelCell(12, 7, POISON);
        addLevelCell(11, 1, WALL);
        addLevelCell(10, 1, WALL);
        addLevelCell(10, 2, WALL);
        addLevelCell(10, 3, WALL);
        addLevelCell(10, 4, WALL);
        addLevelCell(11, 4, WALL);
        addLevelCell(12, 4, WALL);
        addLevelCell(13, 4, WALL);
        addLevelCell(13, 3, WALL);
        addLevelCell(13, 2, WALL);
        addLevelCell(13, 1, WALL);
        addLevelCell(11, 13, WALL);
        addLevelCell(10, 13, WALL);
        addLevelCell(10, 12, WALL);
        addLevelCell(10, 11, WALL);
        addLevelCell(10, 10, WALL);
        addLevelCell(11, 10, WALL);
        addLevelCell(12, 10, WALL);
        addLevelCell(13, 10, WALL);
        addLevelCell(13, 11, WALL);
        addLevelCell(13, 12, WALL);
        addLevelCell(13, 13, WALL);
    }


}
