package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
//<..!..........here iam testing if hero instantiates correctly.......!..................>
    @Test
    public void newHero_instantiatesCorrectly_true() {
        Hero myHero = Hero.setUpNewHero();
        assertTrue(myHero instanceof Hero);
    }
    //<......!testing the getName function if it returns the name..........>
    @Test
    public void newHero_getName_String() {
        Hero newHero = Hero.setUpNewHero();
        assertEquals("Henry",newHero.getName());
    }
   //<...............here am testing if the getPower function returns power......>
    @Test
    public void newHero_getPower_String() {
        Hero newHero = Hero.setUpNewHero();
        assertEquals("Magic",newHero.getPower());
    }
    //.....<!.........testing if getAge returns Age........................>
    @Test
    public void newHero_getAge_Int() {
        Hero newHero = Hero.setUpNewHero();
        assertEquals(73,newHero.getAge());
    }
    //<..............testing if weakness is returned by the getWeakness function.....>
    @Test
    public void newHero_getWeakness_String() {
        Hero newHero = Hero.setUpNewHero();
        assertEquals("Girls",newHero.getWeakness());
    }
    //<..........!....testing all instances are returned...........
    @Test
    public void newHero_getAllInstances_true() {
        Hero myHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        assertTrue(Hero.getAllInstances().contains(myHero));
        assertTrue(Hero.getAllInstances().contains(anotherHero));
    }
    //<...........testing for the correct id........
    @Test
    public void newHero_getId_Int() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero another = Hero.setUpNewHero();
        Hero another1 = Hero.setUpNewHero();
        assertEquals(3,another1.getId());
    }
    //...................testing if a new hero displays the correct id.............>
    @Test
    public void newHero_findById_id() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero another = Hero.setUpNewHero();
        assertEquals(2,Hero.findById(another.getId()).getId());
    }
}