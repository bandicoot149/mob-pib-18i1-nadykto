package ru.sibady;

public class Calc {


    public static void main(String[] args) {
            try {
                if (args.length != 3) {
                    throw new NumberFormatException("wrong number of arguments");
                }
                if (args[1].charAt(0) == '/' && Double.parseDouble(args[2]) == 0) {
                    throw new NumberFormatException("division by 0 is prohibited");
                }
                System.out.println(calc(Double.parseDouble(args[0]), Double.parseDouble(args[2]), args[1].charAt(0)));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
    }

    static double calc(double x, double y, char operation) {
        switch (operation) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case 'x':
                return x * y;
            case '/':
                return x / y;
            default:
                return Double.NaN;
        }
    }
}
