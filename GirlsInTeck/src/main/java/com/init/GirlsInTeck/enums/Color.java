package com.init.GirlsInTeck.enums;

import java.util.stream.Stream;


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
    
    public static Stream<Color> stream() {
        return Stream.of(Color.values()); 
	}
}
