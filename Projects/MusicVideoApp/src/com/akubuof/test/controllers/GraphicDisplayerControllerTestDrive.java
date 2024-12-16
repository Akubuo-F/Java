package com.akubuof.test.controllers;

import com.akubuof.musicvideoapp.controllers.GraphicDisplayerController;
import com.akubuof.musicvideoapp.graphics.shapes.ShapeType;
import com.akubuof.musicvideoapp.models.GraphicDisplayerModel;
import com.akubuof.musicvideoapp.views.GraphicDisplayerView;

import javax.swing.*;

public class GraphicDisplayerControllerTestDrive {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TestDrive");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        GraphicDisplayerView view = new GraphicDisplayerView();
        frame.add(view);

        GraphicDisplayerModel model = new GraphicDisplayerModel(400, 400);
        GraphicDisplayerController controller = new GraphicDisplayerController(model, view);
        controller.generateRandomShape(ShapeType.RECTANGLE);
        controller.displayGraphics();

        frame.setVisible(true);
    }
}
