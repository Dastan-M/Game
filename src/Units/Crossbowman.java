package Units;

public class Crossbowman extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Crossbowman (String name, int age){
        super(name, 80, 10, age, 20, 40, "crossbow", 30);
    }
    public void attack(Person person){
        person.health -= this.power;
    }
    public boolean isInGame(){
        return this.arrowsNum != 0;
    }
}
