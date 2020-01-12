package com.thepot.differentsnakegame;

public enum SnakeHeadDirection {
    UP(R.drawable.ic_backspace_24px_up),
    DOWN(R.drawable.ic_backspace_24px_down),
    LEFT(R.drawable.ic_backspace_24px_left),
    RIGHT(R.drawable.ic_backspace_24px_right);
    private int resource;

    SnakeHeadDirection(int resource) {
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }
}
