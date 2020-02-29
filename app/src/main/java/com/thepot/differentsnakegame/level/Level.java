package com.thepot.differentsnakegame.level;

import com.thepot.differentsnakegame.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Cell> foods;
    private List<Cell> walls;
    private int maxMoves;
    private int moveCount;


    public Level(int maxMoves) {
        this.maxMoves = maxMoves;
        this.moveCount = 0;
        this.foods = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public List<Cell> getFoods() {
        return foods;
    }

    public List<Cell> getWalls() {
        return walls;
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }

    public boolean noMovesLeft() {
        return moveCount >= maxMoves;

    }
}
