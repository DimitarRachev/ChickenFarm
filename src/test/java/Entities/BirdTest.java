package Entities;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BirdTest {

    @Test
    public void testTestEquals() {
        Bird bird1 = new Chicken("name");
        Bird bird2 = new Chicken("name");
        Bird bird3 = new Chicken("otherName");
        assertEquals(bird2, bird1);
        assertNotEquals(bird3, bird1);
    }

    @Test
    public void testIsLifeCycleOver() {
        Bird chicken = new Chicken("someName");
        chicken.weeksLived = 6;
        assertTrue(chicken.isLifeCycleOver());
        chicken.weeksLived = 2;
        assertFalse(chicken.isLifeCycleOver());
        chicken.weeksLived = 666;
        assertTrue(chicken.isLifeCycleOver());
    }

    @Test
    public  void testGetNextStateOfExistence() {
        Bird bird = new Chicken("someName");
            assertNull(bird.getNextStateOfExistence());
            bird = new Egg("someName");
            assertEquals(bird.getNextStateOfExistence().getClass(), Chicken.class);
    }
}