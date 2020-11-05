package airport;

class Plane {
    static final int MAX_FUEL = 10;
    static enum PlaneTypes {
        SMALL, MIDDLE, BIG;
    }
    private final PlaneTypes type;
    private final int timeDepart;
    int fuel;
    private boolean status; // true - air, false - land
    Plane (PlaneTypes type, int fuel, int time) {
        this.type = type;
        this.fuel = fuel;
        this.timeDepart = time;
        this.status = true;
    }
}
