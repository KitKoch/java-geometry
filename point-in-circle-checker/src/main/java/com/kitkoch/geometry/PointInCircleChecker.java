package com.kitkoch.geometry;

import java.util.Scanner;

public final class PointInCircleChecker{

    private PointInCircleChecker(){}
    private record Point(double x, double y) {}

    static Point readPoint(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(!input.hasNextLine()) continue;
            String raw = input.nextLine().trim();
            if(raw.isEmpty()) continue;
            String[] parts = raw.split("\\s+");
            if(parts.length != 2) {
                System.out.println("Please enter exactly 2 numbers (ex: 4 5)");
                continue;
            }
            try {
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                return new Point(x , y);
            } catch (NumberFormatException ex) {
                System.out.println("Both coordinates must be numbers!");
            }
        }
    }

    static double readRadius(Scanner input, String msg) {
        while (true) {
            System.out.print(msg);
            if (!input.hasNextLine()) continue;
            String raw = input.nextLine().trim();
            if (raw.isEmpty()) continue;
            try {
                double radius = Double.parseDouble(raw);
                if (radius > 0) return radius;
                System.out.println("Radius cannot be 0 or negative");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }

    static boolean isPointOnCircle(Point point, Point center, double radiusSquared) {
        double dx = point.x - center.x;
        double dy = point.y - center.y;
        double distance = dx * dx + dy * dy;
        return distance <= radiusSquared;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double radius = readRadius(input, "Enter radius: ");
            double radiusSquared = radius * radius;
            Point center = readPoint(input, "Enter a center point with two coordinates (x , y): ");
            Point point = readPoint(input, "Enter a point with two coordinates (x , y): ");
            boolean inCircle = isPointOnCircle(point, center, radiusSquared);
            System.out.printf("Point (%.1f, %.1f) is %s the circle", point.x, point.y, inCircle ? "in" : "not in");
        }
    }
}
