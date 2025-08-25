package com.kitkoch.geometry;

import java.util.Scanner;

public final class TrianglePerimeterCalculator {

    private TrianglePerimeterCalculator(){}

    private static double readTriangleEdge(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(input.hasNextDouble()) {
                double edge = input.nextDouble();
                if(edge > 0) {
                    return edge;
                }
                System.out.println("Edge cannot be negative");
            } else {
                System.out.println("Please enter a number");
                input.next();
            }
        }
    }

    public static boolean isTriangleValid(double edge1, double edge2, double edge3) {
        return edge1 + edge2 > edge3 && edge2 + edge3 > edge1 && edge1 + edge3 > edge2;
    }

    public static double computerTrianglePerimeter(double edge1, double edge2, double edge3) {
        return edge1 + edge2 + edge3;
    }

    private static void printResults(boolean isValid, double perimeter) {
        if(isValid) {
            System.out.printf("Perimeter of the triangle is %.2f%n", perimeter);
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            double  edge1 = readTriangleEdge(input, "Enter Edge 1: "),
                    edge2 = readTriangleEdge(input, "Enter Edge 2: "),
                    edge3 = readTriangleEdge(input, "Enter Edge 3: ");
            boolean isValid = isTriangleValid(edge1, edge2, edge3);
            double trianglePerimeter = isValid ? computerTrianglePerimeter(edge1, edge2, edge3) : 0;
            printResults(isValid, trianglePerimeter);
        }
    }
}