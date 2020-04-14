package com.thepot.differentsnakegame.model;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private List<Cell> foods;

    public Challenge() {
        this.foods = new ArrayList<>();
    }

    public List<Cell> getLevelCells() {
        return foods;
    }
}
