import greenfoot.*;
import java.util.List;

public class Player extends Actor {

    private static final int SPEED = 3;
    private static final int HALF = 14;
    private int spawnX = 293;
    private int spawnY = 370;
    private boolean hasCoin = false;

    public Player() { }

    @Override
    public void act() {
        move();
        checkDeath();
        pickCoin();
        checkWin();
    }

    private void move() {
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("left")  || Greenfoot.isKeyDown("a")) dx -= SPEED;
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) dx += SPEED;
        if (Greenfoot.isKeyDown("up")    || Greenfoot.isKeyDown("w")) dy -= SPEED;
        if (Greenfoot.isKeyDown("down")  || Greenfoot.isKeyDown("s")) dy += SPEED;

        if (dx != 0) {
            setLocation(getX() + dx, getY());
            if (isWall()) setLocation(getX() - dx, getY());
        }
        if (dy != 0) {
            setLocation(getX(), getY() + dy);
            if (isWall()) setLocation(getX(), getY() - dy);
        }
    }

    private boolean isWall() {
        int px = getX(), py = getY();
        for (Wall w : getWorld().getObjects(Wall.class)) {
            if (overlapsHitbox(px, py, w.getX(), w.getY(), w.getHitWidth(), w.getHitHeight())) return true;
        }
        for (WallH w : getWorld().getObjects(WallH.class)) {
            if (overlapsHitbox(px, py, w.getX(), w.getY(), w.getHitWidth(), w.getHitHeight())) return true;
        }
        for (SmallerWall w : getWorld().getObjects(SmallerWall.class)) {
            if (overlapsHitbox(px, py, w.getX(), w.getY(), w.getHitWidth(), w.getHitHeight())) return true;
        }
        return false;
    }

    private boolean overlapsHitbox(int px, int py, int wx, int wy, int ww, int wh) {
        return Math.abs(px - wx) < (HALF + ww / 2)
            && Math.abs(py - wy) < (HALF + wh / 2);
    }

    private void checkDeath() {
        List<Enemy> enemies = getWorld().getObjects(Enemy.class);
        for (Enemy e : enemies) {
            int dx = e.getX() - getX();
            int dy = e.getY() - getY();
            if (Math.sqrt(dx * dx + dy * dy) < 45) {
                die();
                return;
            }
        }
    }

    private void pickCoin() {
        if (hasCoin) return;
        List<Coin> coins = getWorld().getObjects(Coin.class);
        for (Coin c : coins) {
            int dx = c.getX() - getX();
            int dy = c.getY() - getY();
            if (Math.sqrt(dx * dx + dy * dy) < 35) {
                hasCoin = true;
                getWorld().removeObject(c);
                return;
            }
        }
    }

    private void checkWin() {
        if (!hasCoin) return;
        int dx = getX() - spawnX;
        int dy = getY() - spawnY;
        if (Math.sqrt(dx * dx + dy * dy) < 30) {
            Greenfoot.stop();
        }
    }

    private void die() {
        MyWorld.reiniciarMusica();
        
        hasCoin = false;
        if (getWorld().getObjects(Coin.class).isEmpty()) {
            getWorld().addObject(new Coin(), 153, 137);
        }
        setLocation(spawnX, spawnY);
    }
}