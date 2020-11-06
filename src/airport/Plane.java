package airport;

class Plane {
    static final int MAX_FUEL = 10;

    static enum Types {
        SMALL, MIDDLE, BIG;
    }

    private final Types type;
    private final int timeDepart;
    int fuel;
    private boolean status; // true - air, false - land

    Plane(Types type, int fuel, int time) {
        this.type = type;
        this.fuel = fuel;
        this.timeDepart = time;
        this.status = true;
    }

    public Types getType() {
        return this.type;
    }

    public boolean getStatus() {
        return status;
    }

    public int getTimeDepart() {
        return timeDepart;
    }

    public void land() {
        this.status = false;
    }

    public void fly() {
        this.status = true;
    }

}
