package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import static com.thepot.differentsnakegame.model.CellType.FOOD_MOVE_TO_NEXT_LEVEL;

public class Level9_2 implements Level {
    private LevelService levelService;

    public Level9_2(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.makeWallTransparent(true);
        levelService.updateMoveCount(500);
        levelService.addLevelCell(13, 14, FOOD_MOVE_TO_NEXT_LEVEL);

    }

    @Override
    public double levelNumber() {
        return 9.2;
    }

    @Override
    public double nextLevelNumber() {
        return 100;
    }
}
