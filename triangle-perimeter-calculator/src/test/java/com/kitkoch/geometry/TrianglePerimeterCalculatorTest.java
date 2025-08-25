package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TrianglePerimeterCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "3,4,5,true",   // 3‑4‑5 triangle
            "1,1,2,false",  // degenerate
            "1,2,3,false",
            "5,5,5,true"    // equilateral
    })
    void isTriangleValidWorking(double a, double b, double c, boolean expected) {
        assertEquals(expected, TrianglePerimeterCalculator.isTriangleValid(a, b, c));
    }

    @Test
    void computePerimeter() {
        assertEquals(12, TrianglePerimeterCalculator.computerTrianglePerimeter(3, 4, 5));
    }

}