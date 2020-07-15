
package models;


import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @After
    public void tearDown() throws Exception {
        Hero.clearAll();
    }

//<..............testing if Hero is instantiated correctly..........................................................
    @Test
    public void HeroInstantiatesCorrectly_true() throws Exception{
        Hero hero=setUpNewHero();
        assertEquals(true,hero instanceof Hero);
    }
//<..................testing if getHeroes return all instances of heroes.....................................

    @Test
    public void AllInstancesOfHeroReturned() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        assertEquals(2,Hero.getHeroes().size());
    }
//<......................testing if getName returns correct hero name....................................
    @Test
    public void HeroNameReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "Henry";
        assertEquals(expected, myHero.getName());

    }
//<................................testing if getPowers correctly returns hero power.....................
    @Test
    public void HeroPowerReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "Fire";
        assertEquals(expected, myHero.getPowers());

    }
//<...................testing if getWeakness correctly returns hero weakness............................................
    @Test
    public void HeroWeaknessReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "girls";
        assertEquals(expected, myHero.getWeakness());

    }
//<.....................,teasting if getAge correctly returns hero age.....................................
    @Test
    public void HeroAgeReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 80;
        assertEquals(expected, myHero.getAge());

    }
//<.....................testing if  getDefence correctly returns hero defence number.........................
    @Test
    public void HeroDefenceReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 10;
        assertEquals(expected, myHero.getDefence());

    }
//<........................testing if getAttack correctly returns hero attack number........................
    @Test
    public void HeroAttackReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 10;
        assertEquals(expected, myHero.getAttack());

    }
//<..................testing if all hero instances are contained in Hero............................................
    @Test
    public void HeroContainsAllHeroInstances() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Henry",30,"Fire","girls",10,10);
        assertTrue(Hero.getHeroes().contains(hero));
        assertTrue(Hero.getHeroes().contains(otherHero));
    }

//<testing if all hero instances are returned correctly..................................................

    @Test
    public void deleteAll() {
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Henry",30,"Fire","girls",10,10);
        hero.clearAll();
        assertEquals(0,Hero.getHeroes().size());

    }
//constructor to prevent compilation errors

    private Hero setUpNewHero() {
        return new Hero("Henry",30,"Fire","girls",10,10);
    }

}