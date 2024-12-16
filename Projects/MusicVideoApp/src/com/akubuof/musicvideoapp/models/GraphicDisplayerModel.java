package com.akubuof.musicvideoapp.models;

import com.akubuof.musicvideoapp.graphics.shapes.*;

    public class GraphicDisplayerModel {
    private int canvasWidth;
    private int canvasHeight;
    private final Shape defaultReturnShape;

    public GraphicDisplayerModel(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        defaultReturnShape = new Rectangle(canvasWidth, canvasHeight);
    }

    public ShapeSpecification drawShape(ShapeType shape) {
        switch (shape) {
            case RECTANGLE -> {
                return new Rectangle(canvasWidth, canvasHeight).randomize();
            }
            case OVAL -> {
                return new Oval(canvasWidth, canvasHeight).randomize();
            }
        }
        return defaultReturnShape.randomize();
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }
}

