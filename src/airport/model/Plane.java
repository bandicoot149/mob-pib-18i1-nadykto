package airport.model;

public class Plane {
    public static final int MAX_FUEL = 10;

    private final Size size;
    private final int timeDepart;
    private int fuel;
    private boolean flying;

    public Plane(Size size, int fuel, int time) {
        this.size = size;
        this.fuel = fuel;
        this.timeDepart = time;
        this.flying = true;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean isFlying() {
        return flying;
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

}
