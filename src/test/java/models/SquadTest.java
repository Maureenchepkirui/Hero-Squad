package models;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadTest {

    @After
    public void tearDown() throws Exception {
        Squad.clearAll();
    }
//    <.........................testing is squad instantiates well..................................
    @Test
    public void SquadInstantiatesCorrectly() throws Exception{
        Squad squad= setUpNewSquad();
        assertEquals(true,squad instanceof Squad);
    }
    //<...................testing if getName()instantiates correctly with squad name...........................
    @Test
    public void getName_squadInstantiatesWithName_String() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Henry",30,"Fire","girls",10,10);
        Hero otherHero=new Hero("Barb",40,"Electric eyes","Temper",10,10);
        heroes.add(hero);
        heroes.add(otherHero);
         new Squad(8,"dino","sexism",heroes);
        Squad mySquad= new Squad(10,"knight","illiteracy",heroes);

        assertEquals("knight", mySquad.getName());

    }
    //        <.....................here am testing if maxsize gets instantiated correctly....................................
    @Test
    public void getMaxSize_squadInstantiatesWithMaxSize_Integer() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Henry",30,"Fire","girls",10,10);
        Hero otherHero=new Hero("Barb",40,"Electric eyes","Temper",10,10);
        heroes.add(hero);
        heroes.add(otherHero);
        new Squad(8,"dino","sexism",heroes);
        Squad mySquad= new Squad(10,"knight","illiteracy",heroes);

        assertEquals(10, mySquad.getMaxSize());
    }
//    <.................here am testing if squad cause is returned correctly.....................................
    @Test
    public void getCause_squadInstantiatesWithCause_String() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Henry",30,"Fire","girls",10,10);
        Hero otherHero=new Hero("Barb",40,"Electric eyes","Temper",10,10);
        heroes.add(hero);
        heroes.add(otherHero);
        new Squad(8,"dino","sexism",heroes);
        Squad mySquad= new Squad(10,"knight","illiteracy",heroes);

        assertEquals("illiteracy", mySquad.getCause());
    }
//<............here am testing if squad contains selected heroes............................................
    @Test
    public void squadContainsHeroes_ArrayList() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Henry",30,"Fire","girls",10,10);
        Hero otherHero=new Hero("Barb",40,"Electric eyes","Temper",10,10);
        heroes.add(hero);
        heroes.add(otherHero);
        new Squad(8,"dino","sexism",heroes);
        Squad mySquad= new Squad(10,"knight","illiteracy",heroes);

        assertEquals(heroes, mySquad.getHeroes());
    }
// <..................testing if all instances of squad are returned..........................


    @Test
    public void allInstancesReturned_true() throws Exception {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        assertEquals(2,Squad.getSquads().size());
    }
// <...........Squad contains all instances..............................................................

    @Test
    public void allSquadsAreContainedInSquad_true() throws Exception {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        assertTrue(Squad.getSquads().contains(squad));
        assertTrue(Squad.getSquads().contains(otherSquad));
    }
    //<.............testing if all squads get cleared..........................................................

    @Test
    public void ClearAllClearsAllSquads_true() {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        Squad.clearAll();
        assertEquals(0,Squad.getSquads().size());

    }

//    <.............................constructor...........................................................................
    private Squad setUpNewSquad() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Henry",30,"Fire","girls",10,10);
        Hero otherHero=new Hero("Barb",40,"Electric eyes","Temper",10,10);
        heroes.add(hero);
        heroes.add(otherHero);
        return new Squad(8,"dino","sexism",heroes);
    }
}