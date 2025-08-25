package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PointInRectangleCheckerTest {
    private String runMain(String input) throws Exception {
        InputStream oldInput = System.in;
        PrintStream oldOuput = System.out;
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outBytes));
            PointInRectangleChecker.main(new String[0]);

        } finally {
            System.setIn(oldInput);
            System.setOut(oldOuput);
        }
        return outBytes.toString();
    }

    @Test
    void insideCase() throws Exception {
        //center = (0, 0), width = 10, height = 5, point = (-4.9, 2.49) => in the rectangle
        String out = runMain("0 0\n10\n5\n-4.9 2.49\n");
        assertTrue(out.contains("is in the rectangle"), () -> "Output: " + out);
    }

    @Test
    void outsideCase() throws Exception {
        //center = (0, 0), width = 10, height = 5, point = (-5.1, -2.4) => not in the rectangle
        String out = runMain("0 0\n10\n5\n-5.1 -2.4\n");
        assertTrue(out.contains("not in the rectangle"), () -> "Output: " + out);
    }

    @Test
    void badInputThenSucceed() throws Exception {
        String feed =
                "-1\n10\ntest test\ntest\n0 0\n" +
                "test\n-2\n0\n10\n" +
                "test\n-3\n0\n5\n" +
                "-4\n11\ntest\ntest test\n-4.9 2.49";
        String out = runMain(feed);
        assertTrue(out.contains("Point (-4.90, 2.49) is in the rectangle"), () -> "Output" + out);
    }

}