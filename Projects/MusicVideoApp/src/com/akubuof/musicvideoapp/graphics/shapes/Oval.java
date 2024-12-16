package com.akubuof.musicvideoapp.graphics.shapes;

public class Oval extends Shape{
    public Oval(int canvasWidth, int canvasHeight) {
        super(canvasWidth, canvasHeight);
    }

    @Override
    public ShapeSpecification randomize() {
        return brush -> {
            boolean fill = randomer.nextBoolean();
            brush.setColor(randomColor());

            var width = randomer.nextInt(200);
            var height = randomer.nextInt(200);
            var x = Math.abs(randomer.nextInt(canvasWidth) - width);
            var y = Math.abs(randomer.nextInt(canvasHeight) - height);
            if (fill) {
                brush.fillOval(x, y, width, height);
            } else {
                brush.fillOval(x, y, width, height);
            }
        };
    }
}
