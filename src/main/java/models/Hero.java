package models;

import javax.swing.text.html.HTMLWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Hero {

    private String name;
    private int age;
    private String power;
    private String weakness;
    private boolean occupied;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public void updateHero(boolean occupied) {
        this.occupied = occupied;
    }

    public Hero(String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPower() {
        return this.power;
    }

    public String getWeakness() {
        return this.weakness;
    }

    public static ArrayList<Hero> getAllInstances() {
        return instances;
    }

    public static void clearAllHeroes() {
        instances.clear();
    }

    public int getId() {
        return id;
    }
    public boolean isOccupied() {
        return occupied;
    }

    public static Hero findById(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }

    }


    public static Hero setUpNewHero() {
        return new Hero("Henry", 73, "Magic", "Girls");
    }

    public static Hero setUpNewHero1() {
        return new Hero("KidDanger", 3, "Fire", "Water");
    }

    public static Hero setUpNewHero2() {
        return new Hero("ThunderMan", 90, "Freezing", "Fire");
    }


}

