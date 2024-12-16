package circleanimationapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;


public class CirclePainterApp extends JFrame {
    private final Painter painter;
    private final JButton colorChanger;
    private final int[] circlePosition;

    public static void main(String[] args) {
        new CirclePainterApp().run();
    }

    CirclePainterApp() {
        painter = new Painter();
        colorChanger = new JButton("Animate Circle");
        circlePosition = new int[]{70, 70};
        initUI();
    }

    private void initUI() {
        var x = circlePosition[0];
        var y = circlePosition[1];
        updateCircle(Util.generateRandomColor(), x, y);
        colorChanger.addActionListener(e -> startLinearAnimation());

        add(painter.getCanvas(), BorderLayout.CENTER);
        add(colorChanger, BorderLayout.SOUTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                drawPreviousCircle();
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                drawPreviousCircle();
            }
        });
    }

    public void run() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startLinearAnimation () {
        var startX= Math.max(0, Math.min(circlePosition[0], painter.getCanvasDimension().width - 100));
        var startY= Math.max(0, Math.min(circlePosition[1], painter.getCanvasDimension().height - 100));
        var endX = Math.abs(Util.randomInt(painter.getCanvasDimension().width) - 100);
        var endY = Math.abs(Util.randomInt(painter.getCanvasDimension().height) - 100);

        LinearAnimation linearAnimation = new LinearAnimation(startX, startY, endX, endY);
        linearAnimation.start();

    }

    private void updateCircle(Color color, int x, int y) {
        painter.setPaintSpecification(brush -> {
            paintBackgroundBlack(brush);
            paintCircle(brush, color, x, y);
        });
        circlePosition[0] = x;
        circlePosition[1] = y;
        repaint();
    }

    private void paintCircle(Graphics brush, Color color, int x, int y) {
        brush.setColor(color);
        brush.fillOval(x, y, 100, 100);
    }

    private void paintBackgroundBlack(Graphics brush) {
        brush.setColor(Color.black);
        Dimension canvasDimension = painter.getCanvasDimension();
        brush.fillRect(0, 0, canvasDimension.width, canvasDimension.height);
    }

    private void drawPreviousCircle () {
        var x = circlePosition[0];
        var y = circlePosition[1];
        updateCircle(painter.getBrushColor(), x, y);
    }

    private class LinearAnimation extends Animation {
        private static boolean isAnimating;
        LinearAnimation(int startX, int startY, int endX, int endY) {
            super(startX, startY, endX, endY);
        }
        @Override
        protected void animate() {
            if (!LinearAnimation.isAnimating) {
                LinearAnimation.isAnimating = true;
                System.out.println("Linear animation started");

                while (startX != endX && startY != endY) {
                    try {
                        startX += (endX - startX) / Math.abs(endX - startX);
                        startY += (endY - startY) / Math.abs(endY - startY);
                        updateCircle(Util.generateRandomColor(), startX, startY);
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("paintapp.Animation Completed! \n");
                LinearAnimation.isAnimating = false;
            }
        }
    }
}
