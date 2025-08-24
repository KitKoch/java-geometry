package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinearEquationSolverTest {
    private String runMain(String input) throws Exception {
        InputStream oldInput = System.in;
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outBytes));
            LinearEquationSolver.main(new String[0]);
        } finally {
            System.setIn(oldInput);
            System.setOut(oldOutput);
        }
        return outBytes.toString();
    }

    @Test
    void solveSamples() throws Exception {
        String input = String.join("\n", "9", "4", "3", "-5", "-6", "-21") + "\n";
        String output = runMain(input);
        assertTrue(output.contains("x is -2.00 and y is 3.00"),
                () -> output);
    }

    @Test
    void reportsNoSolutionWhenDeterminantIs0() throws Exception {
        String input = String.join("\n", "1", "2", "2", "4", "4", "5") + "\n";
        String output = runMain(input);
        assertTrue(output.contains("The equation has no solution"), () -> output);
    }

    @Test
    void inputLoopHandlesNonNumber() throws Exception {
        String input = String.join("\n", "a", "9", "b", "4", "c", "3", "d", "-5", "e", "-6", "f", "-21")
                + "\n";
        String output = runMain(input);
        assertTrue(output.contains("x is -2.00 and y is 3.00"), () -> output);
    }
}