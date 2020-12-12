package airport.model;

import java.io.Serializable;
import java.util.List;

public interface Distributor extends Serializable {
    void distribute(List<Plane> planes);
}
