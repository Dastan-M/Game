package Units;

public class Pikeman extends Person {
    public Pikeman (String name, int x, int y) {

        super(name, 100, 10, 20, 30, 40, "pike", 50, x, y);
    }

    public void attack(Person person){
        person.health -= super.power;
    }
}
