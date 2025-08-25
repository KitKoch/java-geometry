package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCoordinateRectangleTest {
    @Test
    void pointIsAlwaysInsideHalfExtents() {
        double width = 200, length = 100;
        for(int i = 0; i < 1_000; i++) {
            var point = RandomCoordinateRectangle.randomCoordinatePoint(width, length);
            assertTrue(point.x() >= - width / 2 && point.x() < width / 2, "x is out of range: " + point.x());
            assertTrue(point.y() >= - length / 2 && point.y() < length / 2, "y is out of range: " + point.y());
        }
    }
}