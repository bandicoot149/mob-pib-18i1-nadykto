package airport;

class Runway {
    private final int number;
    private boolean status; // true - свободно, false - занято
    private final Plane.Types type;

    Runway(Plane.Types type, int number) {
        this.type = type;
        this.status = true;
        this.number = number;
    }

    public Plane.Types getType() {
        return this.type;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getNumber() {
        return  this.number;
    }

    public void close() {
        this.status = false;
    }

    public void open() {
        this.status = true;
    }
}