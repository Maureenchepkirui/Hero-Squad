
package models;


import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @After
    public void tearDown() throws Exception {
        Hero.clearAll();
    }


    @Test
    public void HeroInstantiatesCorrectly_true() throws Exception{
        Hero hero=setUpNewHero();
        assertEquals(true,hero instanceof Hero);
    }

    @Test
    public void AllInstancesOfHeroReturned() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        assertEquals(2,Hero.getHeroes().size());
    }
    @Test
    public void HeroNameReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "Henry";
        assertEquals(expected, myHero.getName());

    }
    @Test
    public void HeroPowerReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "Fire";
        assertEquals(expected, myHero.getPowers());

    }
    @Test
    public void HeroWeaknessReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        String expected = "girls";
        assertEquals(expected, myHero.getWeakness());

    }
    @Test
    public void HeroAgeReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 80;
        assertEquals(expected, myHero.getAge());

    }
    @Test
    public void HeroDefenceReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 10;
        assertEquals(expected, myHero.getDefence());

    }
    @Test
    public void HeroAttackReturnedCorrectly() throws Exception{
        Hero hero =setUpNewHero();
        Hero myHero = new Hero("Henry",80,"Fire","girls",10,10);
        int expected = 10;
        assertEquals(expected, myHero.getAttack());

    }
//
    @Test
    public void HeroContainsAllHeroInstances() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        assertTrue(Hero.getHeroes().contains(hero));
        assertTrue(Hero.getHeroes().contains(otherHero));
    }



    @Test
    public void deleteAll() {
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        hero.clearAll();
        assertEquals(0,Hero.getHeroes().size());

    }


    private Hero setUpNewHero() {
        return new Hero("Henry",30,"Fire","girls",10,10);
    }

}