package Units;

import Units.Person;

import java.util.ArrayList;

public class Sniper extends Shooters {
    public Sniper (String name, int x, int y){

        super(name, 3, 100, 30, 30, 5, 16, 12, x, y);
    }
    @Override
    public String getInfo() {
        return "Sniper";
    }
    @Override
    public String toString() {
        return "[Sniper]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
}
