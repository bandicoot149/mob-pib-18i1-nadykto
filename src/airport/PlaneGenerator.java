package airport;

import airport.model.Plane;
import airport.model.Size;

import java.util.Random;

public class PlaneGenerator {
    public static Plane generate(int date) {
        Random random = new Random();
        Size size = Size.values()[random.nextInt(Size.values().length)];
        date += random.nextInt(4) + 4;
        int fuel = random.nextInt(3) + 3;
        return new Plane(size, fuel, date);
    }
}
