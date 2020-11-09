package airport.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private final List<Runway> runways = new ArrayList<>();
    private final Distributor dispatcherLanding;
    private final Distributor dispatcherDeparting;
    private final Terminal terminal = new Terminal();
    private final List<Plane> planesLanding = new ArrayList<>();
    private final List<Plane> planesDepart = new ArrayList<>();
    private int date;


    public Airport() {
        runways.add(new Runway(Size.BIG, 1));
        runways.add(new Runway(Size.MIDDLE, 2));
        runways.add(new Runway(Size.SMALL, 3));
        this.dispatcherLanding = new DispatcherLanding(this.runways, this.terminal);
        this.dispatcherDeparting = new DispatcherDeparting(this.runways, this.terminal);
        date = 1; // первый день/итерация
    }

    public void takePlane(Plane plane) {
        planesLanding.add(plane);
    }

    public void distributePlanes() {
        this.dispatcherLanding.distribute(planesLanding);
        this.dispatcherDeparting.distribute(planesDepart);
        this.updateLists();
    }

    public void finishDay() {
        for (Runway runway : runways) {
            runway.open();
        }
        date++;
        terminal.cleanMessages();
    }

    public int getDate() {
        return date;
    }

    public void updateTerminal() {
        terminal.outputOnDisplay(this.date);
    }

    public void updateLists() {
        List<Plane> planesBuffer = new ArrayList<>();
        for (Plane plane : this.planesLanding) {
            if (!plane.isFlying()) {
                planesDepart.add(plane);
                planesBuffer.add(plane);
            }
            if (plane.showFuel() <= 0) {
                planesBuffer.add(plane);
                /*так хотелось чтоб самолеты падали, но это накладно, ведь потом эта мертвая душа будет учитываться,
                в идеале диспетчер должен давать обратную связь каким-то образом, но я обошел это во всех случаях*/
            }
        }
        for (Plane plane : planesBuffer) {
            planesLanding.remove(plane);
        }
        planesBuffer.clear();
        for (Plane plane : this.planesDepart) {
            if (plane.isFlying()) {
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
                terminal.addMessage(plane.toString() + " isn't land");
            }
        }
        for (Plane plane : planesDepart) {
            if (plane.getTimeDepart() <= date) {
                terminal.addMessage(plane.toString() + " is late");
            }
        }
    }

    public String toString() {
        return "Airport";
    }
}
