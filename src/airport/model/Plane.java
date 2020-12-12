package airport.model;

import java.io.Serializable;

public class Plane implements Serializable {
    public static final int MAX_FUEL = 10;
    private static int ID = 0; // реализацию я вроде понял, а вот как правильно назвать в таком случае?
    private final int id;
    private final Size size;
    private final int timeDepart;
    private int fuel;
    private boolean flying;

    public Plane(Size size, int fuel, int time) {
        this.size = size;
        this.fuel = fuel;
        this.timeDepart = time;
        this.flying = true;
        this.id = ID;
        ID++;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean isFlying() {
        return flying;
    }

    public boolean isRefuel() {
        return this.fuel == MAX_FUEL;
    }

    public int showFuel() {
        return this.fuel;
    }

    public int getTimeDepart() {
        return timeDepart;
    }

    public void land() {
        this.flying = false;
    }

    public void fly() {
        this.flying = true;
    }

    public boolean makeCircle() {
        this.fuel--;
        return this.fuel <= 0;
    }

    public void refuel() {
        this.fuel = MAX_FUEL;
    }

    public String toString() {
        return "Plane № " + this.id + " " + this.size;
    }
}
