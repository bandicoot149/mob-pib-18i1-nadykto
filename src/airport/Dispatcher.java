package airport;

import java.util.List;

class Dispatcher {
    private List<Runway> runways;
    private Terminal terminal;

    Dispatcher(List<Runway> runways, Terminal terminal) {
        this.runways = runways;
        this.terminal = terminal;
    }

    void disribute(List<Plane> planes) {

        for (Runway runway : runways) {
            for (Plane plane : planes) {
                if (plane.getType() == runway.getType() && runway.getStatus() == true) {
                    if (plane.getStatus()) {
                        plane.land();
                        terminal.getMessege("plane " + plane.getType() + " land on " + runway.getNumber() + " runway");
                    } else {
                        plane.fly();
                        terminal.getMessege("plane " + plane.getType() + " fly on " + runway.getNumber() + " runway");
                    }
                    runway.close();
                }
            }
        }
    }
}