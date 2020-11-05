package airport;

class Runway {
    static enum RunwaysTypes {
        SHORT, MIDDLE, LONG;
    }

    private boolean status; // true - свободно, false - занято
    private final RunwaysTypes type;
    Runway (RunwaysTypes type) {
        this.type = type;
        this.status = true;
    }
}