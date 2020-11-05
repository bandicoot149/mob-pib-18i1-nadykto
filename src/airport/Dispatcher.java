package airport;

import java.util.List;

class Dispatcher {
    private List<Runway> runways;
    private Terminal terminal;
    Dispatcher (List<Runway> runways, Terminal terminal) {
        this.runways = runways;
        this.terminal = terminal;
    }
}
