package com.kitkoch.geometry;

import java.util.Scanner;

public final class PointInRectangleChecker {
    private PointInRectangleChecker(){}
    private record Point( double x, double y) {}

    static double readDimensions(Scanner input, String msg) {
        while(true) {
            System.out.printf("Enter %s: ", msg);
            if(!input.hasNextLine()) continue;
            String raw = input.nextLine().trim();
            if(raw.isEmpty()) continue;
            try {
                double sides = Double.parseDouble(raw);
                if(sides > 0) return sides;
                System.out.printf("%s sides cannot be 0 or negative!%n", msg);
            } catch (NumberFormatException ex) {
                System.out.printf("Please enter a number for the %s sides%n", msg);
            }
        }
    }

    static Point readPoint(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(!input.hasNextLine()) continue;
            String raw = input.nextLine().trim();
            if(raw.isEmpty()) continue;
            String[] parts = raw.split("\\s+");
            if(parts.length != 2) {
                System.out.println("Please enter exactly 2 numbers for a point (ex, 5 6)");
                continue;
            }
            try {
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                return new Point(x, y);
            } catch (NumberFormatException ex) {
                System.out.println("Both coordinates have to be numbers!");
            }
        }
    }

    static boolean isPointInRectangle(Point point, Point center, double width, double height) {
        double dx = Math.abs(point.x - center.x);
        double dy = Math.abs(point.y - center.y);
        return dx <= (width / 2) && dy <= (height / 2);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Point center = readPoint(input, "Enter center point: ");
            double width = readDimensions(input, "width");
            double height = readDimensions(input, "height");
            Point point = readPoint(input, "Enter a point with two coordinates: ");
            boolean inside = isPointInRectangle(point, center, width, height);
            System.out.printf("Point (%.2f, %.2f) is %s the rectangle", point.x, point.y, inside ? "in" : "not in");
        }
    }

}
