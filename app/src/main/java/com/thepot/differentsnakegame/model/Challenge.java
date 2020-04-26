package com.thepot.differentsnakegame.model;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private List<Cell> levelCells;

    public Challenge() {
        this.levelCells = new ArrayList<>();
    }

    public List<Cell> getLevelCells() {
        return levelCells;
    }
}
