package com.akubuof.musicvideoapp.graphics.shapes;

public class Rectangle extends Shape{

    public Rectangle(int canvasWidth, int canvasHeight) {
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
                brush.fillRect(x, y, width, height);
            } else {
                brush.drawRect(x, y, width, height);
            }
        };
    }
}
