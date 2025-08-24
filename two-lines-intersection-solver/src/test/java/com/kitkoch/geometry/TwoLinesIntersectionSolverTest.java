package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoLinesIntersectionSolverTest {
    @Test
    void intersectionMatches() {
        var intersectionPoint = TwoLinesIntersectionSolver.calculateIntersectionPoint(
                new TwoLinesIntersectionSolver.Point(2, 2),
                new TwoLinesIntersectionSolver.Point(5, -1),
                new TwoLinesIntersectionSolver.Point(4, 2),
                new TwoLinesIntersectionSolver.Point(-1, -2)
        );
        assertNotNull(intersectionPoint);
        assertEquals(2.88889, intersectionPoint.x(), 1e-5);
        assertEquals(1.11112, intersectionPoint.y(), 1e-5);
    }

    @Test
    void parallelMatches() {
        var parallel = TwoLinesIntersectionSolver.calculateIntersectionPoint(
                new TwoLinesIntersectionSolver.Point(2, 2),
                new TwoLinesIntersectionSolver.Point(7, 6),
                new TwoLinesIntersectionSolver.Point(4, 2),
                new TwoLinesIntersectionSolver.Point(-1, -2)
        );
        assertNull(parallel);
    }
}