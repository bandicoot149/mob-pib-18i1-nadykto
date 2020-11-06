package airport;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Runway> runways;
    private Dispatcher dispatcher;
    private Terminal terminal;
    private List<Plane> planesLanding;
    private List<Plane> planesDepart;
    private int date;

    public void takePlane(Plane plane) {
        planesLanding.add(plane);
    }

    public void distributePlanes() {
        this.dispatcher.disribute(planesLanding);
        this.dispatcher.disribute(planesDepart);
        this.updateLists();
    }

    public Airport() {
        List<Runway> runways = new ArrayList<Runway>(); // почему так? нам нужно знать что тип одинаков только на уровне ide
        runways.add(new Runway(Plane.Types.BIG, 1));
        runways.add(new Runway(Plane.Types.MIDDLE, 2));
        runways.add(new Runway(Plane.Types.SMALL, 3));
        this.runways = runways;
        this.terminal = new Terminal();
        this.dispatcher = new Dispatcher(this.runways, this.terminal);
        planesLanding = new ArrayList<Plane>();
        planesDepart = new ArrayList<Plane>();
        date = 1; // первый день/итерация
    }

    public void finishDay() {
        for (Runway runway : runways) {
            runway.open();
        }
        date++;
        terminal.cleanmessages();
    }

    public int getDate() {
        return date;
    }

    public void updateTerminal() {
        terminal.OutputOnDisplay(this.date);
    }

    public void updateLists() {
        List<Plane> planesBuffer = new ArrayList<Plane>();
        for (Plane plane : this.planesLanding) {
            if (!plane.getStatus()) {
                planesDepart.add(plane);
                planesBuffer.add(plane);
            }
        }
        for (Plane plane : planesBuffer) {
            planesLanding.remove(plane);
        }
        planesBuffer.clear();
        for (Plane plane : this.planesDepart) {
            if (plane.getStatus()) {
                planesBuffer.add(plane);
            }
        }
        for (Plane plane : planesBuffer) {
            planesDepart.remove(plane);
        }
    }

    public void checkFlights() {
        for (Plane plane : planesLanding) {
            if (plane.getTimeDepart() <= date) {
                terminal.getMessege("Plane " + plane.getType() + " isn't land");
            }
        }
        for (Plane plane : planesDepart) {
            if (plane.getTimeDepart() <= date) {
                terminal.getMessege("Plane " + plane.getType() + " is late");
            }
        }
    }
}
