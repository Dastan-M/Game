package Units;

import java.util.ArrayList;

public class Wizard extends Person {
    protected int mana;
    protected int healVal;
    protected int healPrice;
    protected int attackPrice;

    public Wizard(String name, int x, int y) {
        super(name, 1, 90, 30, 50, 10, 40, "stick", x, y);
        this.mana = 10;
        this.healPrice = 2;
        this.attackPrice = 1;
    }

    public void attack(Person person) {

        person.health -= this.power;
        this.mana -= price("attack");
    }
    public void heal(Person person){
        person.health += this.healVal;
        this.mana -= price("heal");
    }

    private int price(String action) {
        if (action == "heal") return healPrice;
        else if (action == "attack") return attackPrice;
        return 0;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {

    }
}
