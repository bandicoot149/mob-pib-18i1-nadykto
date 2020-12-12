package airport;

import airport.model.Airport;
import airport.model.Plane;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("files/planes.dat");
        Airport airport = new Airport();
        if (file.exists()) {
            airport = readAirport(file);
        }
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int exit = 1;

        while (exit != 0) {
            System.out.println("1 - Сохранить аэропорт");
            System.out.println("2 - Добавить самолет в аэропорт");
            System.out.println("3 - Показать список самолетов");
            System.out.println("0 - Выход");
            exit = in.nextInt();

            switch (exit) {
                case 1: // сохранить
                    saveAirport(file, airport);
                    break;
                case 2: // добавить самолет
                    airport.takePlane(PlaneGenerator.generate(airport.getDate()));
                    break;
                case 3: // показать список самолетов
                    airport.showPlaneLanding();
                default:
                    break;
            }
        }
    }

    private static Airport readAirport(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Airport) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private static void saveAirport (File file, Airport airport) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(airport);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

