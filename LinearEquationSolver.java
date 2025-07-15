import java.util.Scanner;

public class LinearEquationSolver {

    private LinearEquationSolver(){}

    private static final double EPSILON = 1e-12;

    private static double promptDouble(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                System.out.println("Please enter a number");
                input.next();
            }
        }
    }

    private static void calculate(double a, double b, double c, double d, double e, double f) {
        double determinant  = a * d - b * c;
        if(Math.abs(determinant) < EPSILON) {
            System.out.println("The equation has no solution");
            return;
        }
        double edbf = e * d - b * f;
        double afec = a * f - e * c;

        double x = edbf / determinant;
        double y = afec / determinant;
        System.out.printf("x is %.2f and y is %.2f", x, y);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double a = promptDouble(input, "Please enter a: ");
            double b = promptDouble(input, "Please enter b: ");
            double c = promptDouble(input, "Please enter c: ");
            double d = promptDouble(input, "Please enter d: ");
            double e = promptDouble(input, "Please enter e: ");
            double f = promptDouble(input, "Please enter f: ");
            calculate(a, b, c, d, e, f);
        }
    }
}
