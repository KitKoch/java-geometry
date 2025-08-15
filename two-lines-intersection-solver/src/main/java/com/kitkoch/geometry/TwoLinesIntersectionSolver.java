package com.kitkoch.geometry;

import java.util.Scanner;

public final class TwoLinesIntersectionSolver {
    private TwoLinesIntersectionSolver(){}
    private static final double EPSILON = 1e-12;
    public record Point(double x, double y){}

    public static double promptDouble(Scanner input, String msg) {
        while(true) {
            System.out.print("Enter " + msg + ": ");
            if(input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                System.out.println("Please enter a number");
                input.next();
            }
        }
    }

    public static Point calculateIntersectionPoint(Point p1, Point p2, Point p3, Point p4) {
        double a = p1.y - p2.y; //a = (y1 - y2)
        double b = p2.x - p1.x; //b = (x2 - x1)
        double e = (a * p1.x) + (b * p1.y); //e = a*x1 + b*y1

        double c = p3.y - p4.y; //c = (y3 - y4)
        double d = p4.x - p3.x; //d = (x4 - x3)
        double f = (c * p3.x) + (d * p3.y); //f = c*x3 + d*y3

        double determinant = (a * d) - (b * c); //ad - bc == 0 => no solution / parallel
        if(Math.abs(determinant) < EPSILON) {
            return null;
        }
        double x = (e * d - b * f) / determinant; //x = (ed - bf) / (ad - bc)
        double y = (a * f - e * c) / determinant; //y = (af - ec) / (ad - bc)
        return new Point(x , y);
    }

    public static void printResult(Point intersection) {
        if(intersection == null) {
            System.out.println("The two lines are parallel");
        } else {
            System.out.printf("The intersecting point is at (%.2f, %.2f)", intersection.x, intersection.y);
        }
    }

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            double x1 = promptDouble(input, "x1");
            double y1 = promptDouble(input, "y1");
            double x2 = promptDouble(input, "x2");
            double y2 = promptDouble(input, "y2");
            double x3 = promptDouble(input, "x3");
            double y3 = promptDouble(input, "y3");
            double x4 = promptDouble(input, "x4");
            double y4 = promptDouble(input, "y4");

            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x2, y2);
            Point point3 = new Point(x3, y3);
            Point point4 = new Point(x4, y4);

            Point intersection = calculateIntersectionPoint(point1, point2, point3, point4);
            printResult(intersection);
        }
    }
}
