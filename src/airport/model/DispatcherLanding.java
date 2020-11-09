package airport.model;


import java.util.List;

public class DispatcherLanding implements Distributor {
    private final List<Runway> runways;
    private final Terminal terminal;

    public DispatcherLanding(List<Runway> runways, Terminal terminal) {
        this.runways = runways;
        this.terminal = terminal;
    }

    @Override
    public void distribute(List<Plane> planes) {

        for (Runway runway : runways) {
            for (Plane plane : planes) {
                if (plane.getSize() == runway.getSize() && runway.isFree()) {
                    plane.land();
                    terminal.addMessage(plane.toString() + " land on " + runway.toString());
                    runway.close();
                }
            }
        }
        for (Plane plane : planes) {
            if (plane.isFlying()) {
                if (plane.makeCircle()) {
                    terminal.addMessage(plane.toString() + " crashed");
                }
            }
        }
    }

    public String toString() {
        return "Dispatcher landing";
    }
}