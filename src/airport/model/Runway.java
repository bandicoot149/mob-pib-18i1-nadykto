package airport.model;

import java.io.Serializable;

public class Runway implements Serializable {
    private final int number;
    private boolean free;
    private final Size size;

    public Runway(Size size, int number) {
        this.size = size;
        this.free = true;
        this.number = number;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean isFree() {
        return this.free;
    }

    public void close() {
        this.free = false;
    }

    public void open() {
        this.free = true;
    }

    public String toString() {
        return "Runway " + this.number;
    }
}