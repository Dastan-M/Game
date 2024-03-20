package Units;

import java.util.Random;

public abstract class Person {
    protected static Random rnd;
    static { rnd = new Random();}

    protected String name;
    protected int health;
    protected int power;
    protected int age;
    protected int armor;
    protected int endurance;
    protected String weapon;
    protected int gold;
    protected Position position;
        public Person(String name, int health, int power, int age, int armor, int endurance, String weapon, int gold, int x, int y){
        this.name = name;
        this.health = health;
        this.power = power;
        this.age = age;
        this.armor = armor;
        this.endurance = endurance;
        this.weapon = weapon;
        this.gold = gold;
        this.position = new Position(x, y);
    }

    public Person(String name) {
    }

    public String toString(){
        return String.format("[%s] %s", this.getClass().getSimpleName(), this.name + " " + position.getX()+ ":" + position.getY());
    }
    public double getDistance(Person target){
        double targetDistance = Math.sqrt(Math.pow(position.getX()-target.position.getX(), 2) + Math.pow(position.getY()-target.position.getY(), 2));
        return targetDistance;
    }
    private int getRound(int origin, int percent) {
        if (percent > origin)
            return origin;
        int n = (origin * percent) / 100;
        return origin + (rnd.nextInt(0, n * 2 + 1) - n);
    }
//    public int getDamage(int damage){
//            boolean probability = (this.agility/2) >= rnd.nextInt(100);
//            if (probability)
//                return 0;
//            int loss = damage - (this.defence * damage) / 100;
//            loss = Math.min(loss, this.health);
//            this.health -= loss;
//            return loss;
//    }
}
