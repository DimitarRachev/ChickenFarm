import Entities.Bird;
import Entities.Chicken;
import Entities.Egg;
import Entities.WeekState;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BarnTest {
    Barn barn;
    Bird bird;
    Bird deadBird;

    @BeforeMethod
    public void setUp() {
        barn = new Barn();
        bird = new Chicken("someName");
        deadBird = Mockito.mock(Chicken.class);
    }

    @Test
    public void testAddBirdShouldIncreaseBirdsCount() {
        int count = barn.getBirdCount();
        barn.addBird(bird);
        assertEquals(barn.getBirdCount(), count + 1);
    }

    @Test
    public void testAddBirdShouldAddCorrectBird() {
        barn.addBird(bird);
        assertTrue(barn.getBirds().contains(bird));
    }

    @Test
    public void testAnotherWeekPassedShouldMoveTimeline() {
        int weeksLived = bird.getWeeksLived();
        barn.addBird(bird);
        barn.anotherWeekPassed(WeekState.BAD);
        assertEquals(bird.getWeeksLived(), weeksLived + 1);
    }

    @Test
    public void testAnotherWeekPassedShouldRemoveDeadBirds() {
        Mockito.when(deadBird.isLifeCycleOver()).thenReturn(true);
        Mockito.when(deadBird.getNextStateOfExistence()).thenReturn(null);
        Mockito.when(deadBird.getEggs(WeekState.BAD)).thenReturn(new Egg[0]);
        barn.addBird(deadBird);
        barn.anotherWeekPassed(WeekState.BAD);
        assertFalse(barn.getBirds().contains(deadBird));
    }

//    @Test
//    public void testGetState() {
//    }

//    @Test
//    public void testGetBirds() {
//    }
//
//    @Test
//    public void testSetBirds() {
//    }
//
//    @Test
//    public void testGetBirdCount() {
//    }
}