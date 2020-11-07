package airport;

import airport.model.Airport;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int exit = 1;
        while (exit != 0) {
            var planeCount = random.nextInt(3) + 1;
            for (int i = 0; i < planeCount; i++) {
                airport.takePlane(PlaneGenerator.Generate(airport.getDate()));
            }
            airport.distributePlanes();
            airport.checkFlights();
            airport.updateTerminal();
            airport.finishDay();
            exit = in.nextInt();
        }
    }
}
