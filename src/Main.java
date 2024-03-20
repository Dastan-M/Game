import Units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        teamA = createTeam(0, 0);
        teamB = createTeam(0, 3);
        System.out.println(teamA);
        System.out.println(teamB);

        Sniper sniper = new Sniper("Noname", 7, 5);
        Person target = sniper.findNearestEnemy(teamA);
        System.out.println("target from teamA is " + target);
        target = sniper.findNearestEnemy(teamB);
        System.out.println("target from teamB is " + target);
    }
    public static ArrayList<Person> teamA = new ArrayList<Person>();
    public static ArrayList<Person> teamB = new ArrayList<Person>();
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