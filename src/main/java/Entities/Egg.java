package Entities;

public class Egg extends Bird {
    private int LIFE_SPAN = 2;

    public Egg(String lineage) {
        super();
        name = lineage + "Chicken" + serialNumber++ + "\\";
    }

    @Override
    public boolean isLifeCycleOver() {
        return weeksLived == LIFE_SPAN;
    }

    @Override
    public Bird getNextStateOfExistence() {
        return new Chicken(name);
    }

    @Override
    public Egg[] getEggs(WeekState weekState) {
        return new Egg[0];
    }

    @Override
    public String getType() {
        return "Egg";
    }

    public int getLIFE_SPAN() {
        return LIFE_SPAN;
    }
}
