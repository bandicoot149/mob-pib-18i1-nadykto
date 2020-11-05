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
    public Airport () {
        List<Runway> runways = new ArrayList<Runway>(); // почему так? нам нужно знать что тип одинаков только на уровне ide
        runways.add(new Runway(Runway.RunwaysTypes.LONG));
        runways.add(new Runway(Runway.RunwaysTypes.MIDDLE));
        runways.add(new Runway(Runway.RunwaysTypes.SHORT));
        this.runways = runways;
        this.terminal = new Terminal();
        this.dispatcher = new Dispatcher(this.runways, this.terminal);
        planesLanding = new ArrayList<Plane>();
        planesDepart = new ArrayList<Plane>();
        date = 0; // нулевой день/итерация
    }
}
