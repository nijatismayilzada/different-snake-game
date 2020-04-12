package com.thepot.differentsnakegame.model;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private List<Cell> foods;
    private List<Cell> walls;

    public Challenge() {
        this.foods = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public List<Cell> getFoods() {
        return foods;
    }

    public List<Cell> getWalls() {
        return walls;
    }
}
