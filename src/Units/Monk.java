package Units;

public class Monk extends Person {
    protected int mana;
    protected int healVal;
    protected int healPrice;
    protected int attackPrice;
    public Monk (String name, int x, int y){
        super(name, 90, 30, 50, 10, 40, "stick", 30, x, y);
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
}
