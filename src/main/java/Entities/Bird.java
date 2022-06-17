package Entities;

import java.util.Objects;

public abstract class Bird implements Comparable<Bird> {
    protected static int serialNumber = 0;
    protected String name;
    protected int weeksLived;

    public abstract boolean isLifeCycleOver();

    public abstract Bird getNextStateOfExistence();

    public abstract Egg[] getEggs(WeekState weekState);

    public abstract String getType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return name.equals(bird.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Bird o) {
        return this.getName().compareTo(o.getName());
    }

    public static void setSerialNumber(int serialNumber) {
        Bird.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public static int getSerialNumber() {
        return serialNumber;
    }

    public void liveAnotherWeek() {
        weeksLived++;
    }

    public int getWeeksLived() {
        return weeksLived;
    }

    public void setWeeksLived(int weeksLived) {
        this.weeksLived = weeksLived;
    }
}
