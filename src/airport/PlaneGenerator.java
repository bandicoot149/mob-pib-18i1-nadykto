package airport;

public class PlaneGenerator {
    public static Plane Generate (int date) {
        Plane.Types type = Plane.Types.values()[(int)(Math.random()*3)];
        date += (int)(Math.random()*4) + 4;
        int fuel = (int)(Math.random()*3) + 3;
        return new Plane(type, fuel, date);
    }
}
