package com.thepot.differentsnakegame.service;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.thepot.differentsnakegame.model.Cell;
import com.thepot.differentsnakegame.model.CellType;
import com.thepot.differentsnakegame.model.Challenge;
import com.thepot.differentsnakegame.model.CurrentLevel;
import com.thepot.differentsnakegame.repository.LevelRepository;
import com.thepot.differentsnakegame.service.levels.Level;
import com.thepot.differentsnakegame.service.levels.LevelFactory;

import java.util.List;
import java.util.Random;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;

public class LevelService {
    public static final double END_GAME = -1;

    private AppCompatActivity appCompatActivity;
    private CageService cageService;
    private LevelRepository levelRepository;
    private LevelFactory levelFactory;

    // caching
    private Challenge challenge;
    private CurrentLevel currentLevel;

    public LevelService(AppCompatActivity appCompatActivity, CageService cageService, LevelRepository levelRepository) {
        this.appCompatActivity = appCompatActivity;
        this.cageService = cageService;
        this.levelRepository = levelRepository;
        this.levelFactory = new LevelFactory(this);

    }


    public void drawLevel(Canvas canvas) {
        if (getCurrentLevel() != null) {
            for (Cell cell : challenge.getLevelCells()) {
                int resource = cell.getCellType().getResource();
                if (resource != 0) {
                    Drawable d = appCompatActivity.getResources().getDrawable(resource, null);
                    d.setBounds(cell.getRect());
                    d.draw(canvas);
                }
            }
        }
    }

    public void makeWallTransparent(boolean transparentWall) {
        getCurrentLevel().setTransparentWall(transparentWall);
        levelRepository.updateCurrentLevel(getCurrentLevel());
    }

    public void updateMoveCount(int moveCount) {
        getCurrentLevel().setMovesLeft(moveCount);
        levelRepository.updateCurrentLevel(getCurrentLevel());
    }

    public void addLevelCell(int y, int x, CellType cellType) {
        cageService.updateCellType(cageService.getCage().cells[y][x], cellType);
        challenge.getLevelCells().add(cageService.getCage().cells[y][x]);
    }

    public CurrentLevel getCurrentLevel() {
        if (currentLevel == null) {
            currentLevel = levelRepository.getCurrentLevelDetails();
            if (currentLevel == null) {
                currentLevel = new CurrentLevel();
                currentLevel.setCurrentLevel(0);
                currentLevel.setMovesLeft(0);
                levelRepository.insertCurrentLevel(currentLevel);
                loadNextLevel();
            } else {
                challenge = new Challenge();
                challenge.getLevelCells().addAll(cageService.findCellsOfTypes(CellType.getLevelSpecificTypes()));
            }
        }

        return currentLevel;
    }

    public void loadNextLevel() {

        cageService.clearCells(CellType.getLevelSpecificTypes());

        Level activeLevel = levelFactory.getLevel(getCurrentLevel().getCurrentLevel());
        Level nextLevel = levelFactory.getLevel(activeLevel.nextLevelNumber());

        challenge = new Challenge();
        getCurrentLevel().setCurrentLevel(nextLevel.levelNumber());
        levelRepository.updateCurrentLevel(getCurrentLevel());
        nextLevel.loadLevel();
    }

    public void loadRandomFood() {

        updateMoveCount(-1);

        challenge = new Challenge();


        List<Cell> emptyCells = cageService.findCellsOfTypes(CellType.EMPTY);


        Cell cell = emptyCells.get(new Random().nextInt(emptyCells.size()));

        cageService.updateCellType(cell, FOOD_MOVE_TO_NEXT_LEVEL);
        challenge.getLevelCells().add(cell);

    }

}
