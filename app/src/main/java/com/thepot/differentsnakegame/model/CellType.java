package com.thepot.differentsnakegame.model;

import com.thepot.differentsnakegame.R;

import java.util.ArrayList;
import java.util.List;

public enum CellType {
    EMPTY(0, true, false),
    SNAKE_HEAD_UP(R.drawable.ic_backspace_24px_up, false, false),
    SNAKE_HEAD_DOWN(R.drawable.ic_backspace_24px_down, false, false),
    SNAKE_HEAD_LEFT(R.drawable.ic_backspace_24px_left, false, false),
    SNAKE_HEAD_RIGHT(R.drawable.ic_backspace_24px_right, false, false),
    SNAKE_BODY(R.drawable.ic_add_box_24px, false, false),
    FOOD(R.drawable.ic_add_circle_24px, true, true),
    FLARE(R.drawable.ic_flare_white_24dp, true, true),
    POISON(R.drawable.ic_remove_circle_24px, true, true),
    FOOD_MOVE_TO_NEXT_LEVEL(R.drawable.ic_add_circle_24px, true, true),
    WALL(R.drawable.ic_border_all_white_24dp, false, true),
    OBSTACLE(R.drawable.ic_border_outer_white_24dp, true, true),
    SAVE(R.drawable.ic_cloud_upload_white_24dp, true, true);


    private int resource;
    private boolean actionable;
    private boolean levelSpecific;


    CellType(int resource, boolean actionable, boolean levelSpecific) {
        this.resource = resource;
        this.actionable = actionable;
        this.levelSpecific = levelSpecific;
    }

    public int getResource() {
        return resource;
    }

    public boolean isNotActionable() {
        return !actionable;
    }

    public boolean isLevelSpecific() {
        return levelSpecific;
    }

    public static CellType[] getLevelSpecificTypes() {
        CellType[] cellTypes = CellType.class.getEnumConstants();

        List<CellType> levelSpecificTypes = new ArrayList<>();

        for (CellType cellType : cellTypes) {
            if (cellType.isLevelSpecific()) {
                levelSpecificTypes.add(cellType);
            }

        }

        return levelSpecificTypes.toArray(new CellType[0]);
    }
}
