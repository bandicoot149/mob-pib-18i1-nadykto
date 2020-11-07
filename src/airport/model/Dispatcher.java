package airport.model;


import java.util.List;

public class Dispatcher implements Distributer {
    private final List<Runway> runways;
    private final Terminal terminal;

    public Dispatcher(List<Runway> runways, Terminal terminal) {
        this.runways = runways;
        this.terminal = terminal;
    }

    @Override
    public void distribute(List<Plane> planes) {

        for (Runway runway : runways) {
            for (Plane plane : planes) {
                if (plane.getSize() == runway.getSize() && runway.isFree()) {
                    if (plane.isFlying()) {
                        plane.land();
                        terminal.addMessage("plane " + plane.getSize() + " land on " + runway.getNumber() + " runway");
                    } else {
                        plane.fly();
                        terminal.addMessage("plane " + plane.getSize() + " fly on " + runway.getNumber() + " runway");
                    }
                    runway.close();
                }
            }
        }
    }
}