package airport;

import airport.model.Plane;
import airport.model.Size;

import java.util.Random;

public class PlaneGenerator {
    public static Plane generate(int date) {
        Random random = new Random();
        Size size = Size.values()[random.nextInt(Size.values().length)];
        date += random.nextInt(3) + 1;
        int fuel = random.nextInt(2) + 4;
        return new Plane(size, fuel, date);
    }
}
