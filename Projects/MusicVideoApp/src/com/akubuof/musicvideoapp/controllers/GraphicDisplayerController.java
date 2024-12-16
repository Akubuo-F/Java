package com.akubuof.musicvideoapp.controllers;

import com.akubuof.musicvideoapp.graphics.shapes.ShapeSpecification;
import com.akubuof.musicvideoapp.graphics.shapes.ShapeType;
import com.akubuof.musicvideoapp.models.GraphicDisplayerModel;
import com.akubuof.musicvideoapp.views.GraphicDisplayerView;

public class GraphicDisplayerController {
    private final GraphicDisplayerModel model;
    private final GraphicDisplayerView view;

    public GraphicDisplayerController(GraphicDisplayerModel model, GraphicDisplayerView view) {
        this.model = model;
        this.view = view;
    }

    public void generateRandomShape(ShapeType shape) {
        ShapeSpecification specification = model.drawShape(shape);
        view.setGraphicSpecification(specification);
    }

    public void displayGraphics() {
        view.repaint();
    }
}
