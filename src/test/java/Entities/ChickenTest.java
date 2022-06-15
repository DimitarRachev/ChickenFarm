package Entities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChickenTest {
    Chicken chicken;

    @BeforeMethod
    public void setUp() {
        chicken = new Chicken("Test chicken");
    }



    @Test
    public void testLiveAnotherWeekShouldIncreaseAge() {
        int age = chicken.getWeeksLived();
        chicken.liveAnotherWeek();
        assertEquals(chicken.getWeeksLived(), age + 1);
    }

    @Test
    public void testGetEggsShouldReturnCorrectNumberOfEggs() {
        chicken.weeksLived = 3;
        Egg[] eggs = chicken.getEggs(WeekState.BAD);
        assertEquals(eggs.length, 0);
        eggs = chicken.getEggs(WeekState.NORMAL);
        assertEquals(eggs.length, 1);
        eggs = chicken.getEggs(WeekState.GOOD);
        assertEquals(eggs.length, 3);
        chicken.weeksLived = 1;
        eggs = chicken.getEggs(WeekState.BAD);
        assertEquals(eggs.length, 0);
        eggs = chicken.getEggs(WeekState.NORMAL);
        assertEquals(eggs.length, 0);
        eggs = chicken.getEggs(WeekState.GOOD);
        assertEquals(eggs.length, 0);
        chicken.weeksLived = 5;
        eggs = chicken.getEggs(WeekState.BAD);
        assertEquals(eggs.length, 0);
        eggs = chicken.getEggs(WeekState.NORMAL);
        assertEquals(eggs.length, 0);
        eggs = chicken.getEggs(WeekState.GOOD);
        assertEquals(eggs.length, 0);
    }
}