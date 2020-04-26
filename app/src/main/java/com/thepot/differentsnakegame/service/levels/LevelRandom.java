package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

public class LevelRandom implements Level {
    private LevelService levelService;

    public LevelRandom(LevelService levelService) {
        this.levelService = levelService;
    }

    @Override
    public void loadLevel() {
        levelService.loadRandomFood();
    }

    @Override
    public double levelNumber() {
        return 100;
    }

    @Override
    public double nextLevelNumber() {
        return 100;
    }
}
