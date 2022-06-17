package Entities;

public class Chicken extends Bird {
    private int LIFE_SPAN = 6;

    public Chicken(String name) {
        super();
        super.name = name;
    }

    @Override
    public boolean isLifeCycleOver() {
        return weeksLived >= LIFE_SPAN;
    }

    @Override
    public Bird getNextStateOfExistence() {
        return null;
    }
    @Override
    public Egg[] getEggs(WeekState weekState) {
        if (weeksLived >= 2 && weeksLived <= 4) {
            switch (weekState) {
                case GOOD:
                    return new Egg[]{new Egg(name), new Egg(name), new Egg(name)};
                case NORMAL:
                    return new Egg[]{new Egg(name)};
            }
        }
        return new Egg[0];
    }

    @Override
    public String getType() {
        return "Chicken";
    }

    public int getLIFE_SPAN() {
        return LIFE_SPAN;
    }
}
