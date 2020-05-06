package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;

public class Level9_1 implements Level {
    private LevelService levelService;

    public Level9_1(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.updateMoveCount(-1);
        levelService.addLevelCell(13, 1, FOOD_MOVE_TO_NEXT_LEVEL);
    }

    @Override
    public double levelNumber() {
        return 9.1;
    }

    @Override
    public double nextLevelNumber() {
        return 9.2;
    }
}
