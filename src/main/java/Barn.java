import Entities.Bird;
import Entities.WeekState;
import java.util.*;
import java.util.stream.Collectors;

public class Barn {
    private Set<Bird> birds;

    public Barn() {
        birds = new TreeSet<>();
    }

    public boolean addBird(Bird bird) {
        return birds.add(bird);
    }

    public void anotherWeekPassed(WeekState weekState) {
        List<Bird> birdsToAdd = new ArrayList<>();
        List<Bird> birdsToRemove = new ArrayList<>();
        for (Bird bird : birds) {
            bird.liveAnotherWeek();
            birdsToAdd.addAll(List.of(bird.getEggs(weekState)));

            if (bird.isLifeCycleOver()) {
                Bird next = bird.getNextStateOfExistence();
                birdsToRemove.add(bird);
                if (next != null) {
                    birdsToAdd.add(next);
                }
            }
        }
        birdsToRemove.forEach(birds::remove);
        birds.addAll(birdsToAdd);
    }

    public String getState() {
        Map<Boolean, List<Bird>> chicken = birds.stream().collect(Collectors.partitioningBy(e -> e.getType().equals("Chicken")));
        return chicken.get(true).stream().map(Bird::getName).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator() + "Eggs: " + chicken.get(false).size();
        // output with age for debugging purposes
        //        return chicken.get(true).stream().map(b -> b.getName() + " " + b.getAge()).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator() + "Eggs: " + chicken.get(false).size();
    }

    public Set<Bird> getBirds() {
        return birds;
    }

    public void setBirds(Set<Bird> birds) {
        this.birds = birds;
    }

    public int getBirdCount() {
        return birds.size();
    }
}