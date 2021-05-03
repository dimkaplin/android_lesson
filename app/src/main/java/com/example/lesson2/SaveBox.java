package com.example.lesson2;

import java.io.Serializable;

public class SaveBox implements Serializable {
    private String currentClick;

    public SaveBox() {
        currentClick = "";
    }

    public String getCurrentClick() {
        return currentClick;
    }

    public void setCurrentClick(String currentClick) {
        this.currentClick = currentClick;
    }
}
