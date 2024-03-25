import Units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        teamA = createTeam(0, 0);
        teamB = createTeam(0, 3);
        all.addAll(teamA);
        all.addAll(teamB);
        all.sort(new PrioritySort());
        for (Person hero : all){
            System.out.println(hero + " makes step");
            if (teamA.contains(hero)){
                hero.step(teamB);
            } else {
                hero.step(teamA);
            }
        }
    }
    public static ArrayList<Person> teamA = new ArrayList<Person>();
    public static ArrayList<Person> teamB = new ArrayList<Person>();
    public static ArrayList<Person> all = new ArrayList<>();
    private static ArrayList<Person> createTeam(int val, int num){
        ArrayList<Person> team = new ArrayList<Person>();
        int teamCount = 10;
        for (int i = 0; i < teamCount; i++) {
            switch (new Random().nextInt(4) + num){
                case 0:
                    team.add(new Crossbowman(getName(), 0, i));
                    break;
                case 1:
                    team.add(new Pikeman(getName(), 0, i));
                    break;
                case 2:
                    team.add(new Wizard(getName(), 0, i));
                    break;
                case 3:
                    team.add(new Peasant(getName(), num*3, i));
                    break;
                case 4:
                    team.add(new Sniper(getName(), 9, i));
                    break;
                case 5:
                    team.add(new Monk(getName(),9, i));
                    break;
                case 6:
                    team.add(new Robber(getName(), 9, i));
                    break;
            }
        }
        return team;
    }
    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }
}