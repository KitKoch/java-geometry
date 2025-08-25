package com.kitkoch.geometry;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomCoordinateRectangle {

    private RandomCoordinateRectangle(){}

    public record Point(double x, double y){}

    private static double inputDimensions(Scanner input, String msg) {
        while(true) {
            System.out.print("Please enter " + msg + ": ");
            if(input.hasNextDouble()) {
                double dimension = input.nextDouble();
                if(dimension > 0) return dimension;
                System.out.println("Value has to be greater than 0");
            } else {
                System.out.println("Please enter a number");
                input.next();
            }
        }
    }

    public static Point randomCoordinatePoint(double width, double length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = random.nextDouble(- width / 2, width / 2);
        double y = random.nextDouble(- length / 2, length / 2);
        if(x == -0) x = 0;
        if(y == -0) y = 0;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double width = inputDimensions(input, "width");
            double length = inputDimensions(input, "length");
            Point coordinatePoint = randomCoordinatePoint(width, length);
            System.out.printf("Random coordinate inside the rectangle is (%.2f, %.2f)", coordinatePoint.x, coordinatePoint.y);
        }
    }
}
