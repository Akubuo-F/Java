package circleanimationapp;

import javax.swing.*;
import java.awt.*;

public class Painter {
    private final Canvas canvas;
    private Color brushColor;
    private PaintSpecification specification;

    public Painter() {
        this.canvas = new Canvas();
    }

    public void setPaintSpecification(PaintSpecification specification) {
        this.specification = specification;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public Color getBrushColor() {
        return brushColor;
    }

    public Dimension getCanvasDimension() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    private class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics cloneBrush = g.create();
            specification.apply(cloneBrush);
            brushColor = cloneBrush.getColor();
            cloneBrush.dispose();
        }
    }
}
