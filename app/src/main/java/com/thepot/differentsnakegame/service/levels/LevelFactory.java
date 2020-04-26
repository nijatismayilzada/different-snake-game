package com.thepot.differentsnakegame.service.levels;

import com.thepot.differentsnakegame.service.LevelService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelFactory {

    private Map<Double, Level> levelsMap;

    public LevelFactory(LevelService levelService) {

        List<Level> levels = new ArrayList<>();
        levels.add(new Level0());
        levels.add(new Level1(levelService));
        levels.add(new Level2(levelService));
        levels.add(new Level3(levelService));
        levels.add(new Level4(levelService));
        levels.add(new Level5(levelService));
        levels.add(new Level6(levelService));
        levels.add(new Level7(levelService));
        levels.add(new Level8(levelService));
        levels.add(new Level9_1(levelService));
        levels.add(new Level9_2(levelService));
        levels.add(new LevelRandom(levelService));

        levelsMap = new HashMap<>();
        for (Level level : levels) {
            levelsMap.put(level.levelNumber(), level);
        }
    }

    public Level getLevel(double levelNumber) {

        Level level = levelsMap.get(levelNumber);

        if (level == null) {
            throw new IllegalArgumentException("Could not find level " + levelNumber);
        }

        return level;
    }
}
