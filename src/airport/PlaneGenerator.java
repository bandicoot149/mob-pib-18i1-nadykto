package airport;

import airport.model.Plane;

import java.util.Random;

public class PlaneGenerator {
    public static Plane Generate(int date) {
        Random random = new Random();
        Plane.Types type = Plane.Types.values()[random.nextInt(Plane.Types.values().length)];
        date += random.nextInt(4) + 4;
        int fuel = random.nextInt(3) + 3;
        return new Plane(type, fuel, date);
    }
}
