package Units;

import java.util.ArrayList;

public class Pikeman extends Warriors {
    public Pikeman(String name, int x, int y) {

        super(name, 2, 100, 60, 10, 20, 12, x, y);
    }
    @Override
    public String toString() {
        return "[Pikeman]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Pikeman " + definition;
    }
}
