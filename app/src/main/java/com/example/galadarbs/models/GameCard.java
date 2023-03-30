package com.example.galadarbs.models;


public class GameCard {

    private final int value;
    private final int imageResource;
    private boolean isOpened;

    public GameCard(int value, int imageResource) {
        this.value = value;
        this.imageResource = imageResource;
        isOpened = false;
    }

    public int getValue() {
        return value;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }
}

