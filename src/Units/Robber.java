package Units;

import java.util.ArrayList;

public class Robber extends Person {
    public Robber (String name, int x, int y) {

        super(name, 2, 100, 10, 25, 20, 40, "knife", x, y);
    }

    public void attack(Person person){
        person.health -= super.power;
    }

    @Override
    public void step(ArrayList<Person> enemies) {

    }
}
