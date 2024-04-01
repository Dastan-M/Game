package Units;


import java.util.ArrayList;
import java.util.Random;

public abstract class Person implements GameInterface {
    protected static Random rnd;

    static {
        rnd = new Random();
    }

    protected String name;
    protected int health;
    public int priority;
    protected final int maxHealth;
    protected final int power;
    protected final int agility;
    protected final int defence;
    protected int distance;
    protected Position position;
    boolean isDie = Boolean.FALSE;
    protected int x, y;
    private static int width;
    private static int height;
    static {width = 10; height = 10;}
    protected String definition;

    protected Person(String name, int priority, int health, int power, int agility, int defence, int distance, int x, int y) {
        this.name = name;
        this.priority = priority;
        this.health = getRound(health, 10);
        this.maxHealth = this.health;
        this.power = getRound(power, 10);
        this.agility = getRound(agility, 10);
        this.defence = defence;
        this.distance = distance;
        this.position = new Position(x, y);
        this.definition = "";
    }

    public String toString() {
        return String.format("[%s] %s", this.getClass().getSimpleName(), this.name + " " + position.getX() + ":" + position.getY());
    }

    public double getDistance(Person target) {
        double targetDistance = Math.sqrt(Math.pow(position.getX() - target.position.getX(), 2) + Math.pow(position.getY() - target.position.getY(), 2));
        return targetDistance;
    }

    protected int getRound(int origin, int percent) {
        if (percent > origin)
            return origin;
        int n = (origin * percent) / 100;
        return origin + (rnd.nextInt(0, n * 2 + 1) - n);
    }
    public void setPosition(int x, int y){position.setXY(x, y);}
    public Position getPosition(){return position;}
    public void healed(int health){this.health = Math.min(this.health + health, this.maxHealth);}
    public int getDamage(int damage) {
        boolean probability = (this.agility / 2) >= rnd.nextInt(100);
        if (probability) {
//            System.out.println(name + ": you've missed!");
            return 0;
        }
        int loss = damage - (this.defence * damage) / 100;
        loss = Math.min(loss, this.health);
        this.health -= loss;
//        if (this.health <= 0) {
//            System.out.println(name + ": I'm out!");
//        }
        return loss;
    }
    public boolean isMove(double x, double y){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public void moveTo(int dx, int dy){
        if(isMove(this.x+dx, this.y+dy)){
            this.x += dx;
            this.y += dy;
        }
    }
    public Person findNearestEnemy(ArrayList<Person> persons) {
        Person target = null;
        float distance = Float.MAX_VALUE;
        for (Person hero : persons) {
            float dist = position.distanceTo(hero.position);
            if (dist < distance) {
                distance = dist;
                target = hero;
            }
        }
        return target;
    }

    public boolean isDie() {
        return isDie;
    }

    public int[] getCoords() {
        return new int[]{position.getY(), position.getX()};
    }

    public int getHealth() {
        return health;
    }
}
