package Units;

import java.util.ArrayList;

public class Crossbowman extends Shooters {
    private int arrowsNum;
    boolean inGame = true;

    public Crossbowman(String name, int x, int y) {

        super(name, 3, 100, 30, 25, 10, 16, 12, x, y);
    }
    @Override
    public String toString() {
        return "Crosssbowman{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Crossbowman " + definition;
    }


}

