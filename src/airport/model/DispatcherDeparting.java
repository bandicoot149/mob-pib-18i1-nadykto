package airport.model;

import java.util.List;

public class DispatcherDeparting implements Distributor {
    private final List<Runway> runways;
    private final Terminal terminal;

    public DispatcherDeparting(List<Runway> runways, Terminal terminal) {
        this.runways = runways;
        this.terminal = terminal;
    }

    @Override
    public void distribute(List<Plane> planes) {
        for (Runway runway : runways) {
            for (Plane plane : planes) {
                if (plane.getSize() == runway.getSize() && runway.isFree() && plane.isRefuel()) {
                    plane.fly();
                    terminal.addMessage(plane.toString() + " fly on " + runway.toString());
                    runway.close();
                }
            }
        }
        for (Plane plane : planes) {
            if (!plane.isRefuel()) {
                plane.refuel();
            }
        }
    }

    public String toString() {
        return "Dispatcher departing";
    }
}
