package com.akubuof.musicvideoapp.graphics.shapes;

import java.awt.*;
import java.util.Random;

public abstract class Shape {
    protected int canvasWidth;
    protected int canvasHeight;
    protected final Random randomer;

    Shape(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        randomer = new Random();
    }

    protected Color randomColor () {
        var r = randomer.nextInt(256);
        var g = randomer.nextInt(256);
        var b = randomer.nextInt(256);
        return new Color(r, g, b);
    }

    public abstract ShapeSpecification randomize();
}
