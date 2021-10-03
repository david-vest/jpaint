package model;

import java.awt.*;

/**
 * ShapeColor holds the enum values for the shape color choices.
 */

public enum ShapeColor {
    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    CYAN(Color.CYAN),
    DARK_GRAY(Color.DARK_GRAY),
    GRAY(Color.GRAY),
    GREEN(Color.GREEN),
    LIGHT_GRAY(Color.LIGHT_GRAY),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK),
    RED(Color.RED),
    WHITE(Color.WHITE),
    YELLOW(Color.YELLOW);

    private final Color jColor;

    ShapeColor(Color jColor) {
        this.jColor = jColor;
    }

    /**
     * Converts the enum value of ShapeColor to the Java awt color
     * @return java.avt.Color
     */
    public Color get(){
        return this.jColor;
    }
}
