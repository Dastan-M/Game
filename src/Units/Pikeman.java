package Units;

public class Pikeman extends Person {
    public Pikeman (String name, int age) {

        super(name, 100, 10, age, 30, 40, "pike", 50);
    }

    public void attack(Person person){
        person.health -= super.power;
    }
}
