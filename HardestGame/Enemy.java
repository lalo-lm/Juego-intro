import greenfoot.*;

public class Enemy extends Actor {

    private static final int[][] WAYPOINTS = {
        {153, 233},
        {434, 233},
        {434, 516},
        {153, 516}
    };

    private static final int SNAP_DIST = 6;
    private int targetIndex;
    private int speed;

    public Enemy(int startX, int startY, int startTarget, int speed) {
        this.targetIndex = startTarget;
        this.speed = speed;
    }

    public Enemy() {
        this(153, 233, 1, 2);
    }

    @Override
    public void act() {
        int tx = WAYPOINTS[targetIndex][0];
        int ty = WAYPOINTS[targetIndex][1];
        int cx = getX();
        int cy = getY();
        double dist = Math.sqrt((tx - cx) * (tx - cx) + (ty - cy) * (ty - cy));
        if (dist <= SNAP_DIST) {
            setLocation(tx, ty);
            targetIndex = (targetIndex + 1) % WAYPOINTS.length;
        } else {
            double ratio = speed / dist;
            int nx = (int) Math.round(cx + (tx - cx) * ratio);
            int ny = (int) Math.round(cy + (ty - cy) * ratio);
            setLocation(nx, ny);
        }
    }
}
