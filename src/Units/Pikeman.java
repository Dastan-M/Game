package Units;

import java.util.ArrayList;

public class Pikeman extends Person {
    public Pikeman (String name, int x, int y) {

        super(name, 2, 100, 10, 20, 30, 40, "pike", x, y);
    }

    public void attack(Person person){
        person.health -= super.power;
    }

    @Override
    public void step(ArrayList<Person> enemies) {

    }
}
