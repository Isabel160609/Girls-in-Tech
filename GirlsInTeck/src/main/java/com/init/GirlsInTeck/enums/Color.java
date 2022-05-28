package com.init.GirlsInTeck.enums;

public enum Color {

  RED("red"), GREEN("green"), YELLOW("yellow"), PURPLE("purple");

  private String colorName;

    private Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
