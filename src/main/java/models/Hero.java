package models;

import javax.swing.text.html.HTMLWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Hero {

    private String name;
    private int age;
    private String power;
    private String weakness;
    private String defence;
    private String attack;
    private int speed;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness,String defence,String  attack,Integer speed) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.defence = defence;
        this.speed =  speed;
        this.attack =attack;
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
    public static void clearAllHeroes(){
        instances.clear();
    }
    public int getId(){
        return id;
    }
    public String  getDefence(){
        return defence;
    }
    public String getAttack(){
        return attack;
    }
    public int getSpeed(){
        return speed;
    }
    public static Hero findById(int id) {
        return instances.get(id-1);
    }


    public static Hero setUpNewHero(){
        return new Hero("Henry",73,"Magic","Girls","center","left-center",200);
    }
    public static Hero setUpNewHero1(){
        return new Hero("KidDanger",3,"Fire","Water","corner","center",500);
    }
    public static Hero setUpNewHero2(){
        return new Hero("ThunderMan",90,"Freezing","Fire","center","right",150);
    }

}
