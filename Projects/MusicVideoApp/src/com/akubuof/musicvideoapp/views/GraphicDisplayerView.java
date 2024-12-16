package com.akubuof.musicvideoapp.views;

import com.akubuof.musicvideoapp.graphics.GraphicSpecification;

import javax.swing.*;
import java.awt.*;

public class GraphicDisplayerView extends JPanel {
    private GraphicSpecification specification;

    public GraphicDisplayerView () {
        specification = new GraphicSpecification() {
            @Override
            public void apply(Graphics brush) {}
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics brush = g.create();
        specification.apply(brush);
        brush.dispose();
    }

    public void setGraphicSpecification(GraphicSpecification specification) {
        this.specification = specification;
    }
}
