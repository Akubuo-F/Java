package circleanimationapp;

public abstract class Animation {
    protected int startX;
    protected int startY;
    protected final int endX;
    protected final int endY;

    Animation(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void start () {
        Thread animationThread = new Thread(this::animate);
        animationThread.start();
    }

    protected abstract void animate();
}
