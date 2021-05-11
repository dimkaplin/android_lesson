package com.example.lesson2;

import java.io.Serializable;

public class SaveBox implements Serializable {
    private String currentClick;

    private String firstNumber;
    private String secondNumber;
    private String operation;
    private int currentNumber;
    private boolean isEqual;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public SaveBox() {
        currentClick = "";
        firstNumber = "";
        secondNumber = "";
        operation = "";
        currentNumber = 1;
        isEqual = false;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public void setEqual(boolean equal) {
        isEqual = equal;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCurrentClick() {
        return currentClick;
    }

    public void setCurrentClick(String currentClick) {
        this.currentClick = currentClick;
    }

    public void setNumber(String inp) {
        if (this.getCurrentNumber() == 1) {
            this.setFirstNumber(this.getFirstNumber() + inp);
        }
        else {
            this.setSecondNumber(this.getSecondNumber() + inp);
        }
    }

    public String getOperationResult() {
        int one = Integer.parseInt(this.getFirstNumber());
        int two = Integer.parseInt(this.getSecondNumber());
        double res = 0;
        switch (this.getOperation()) {
            case "+":
                res = one + two;
                break;
            case  "-":
                res = one - two;
                break;
            case "X":
                res = one * two;
                break;
            case "/":
                res = one / two;
                break;
        }
        String res_str = String.valueOf(res);
        return res_str.substring(0, res_str.lastIndexOf("."));
    }
}
