package com.kitkoch.geometry;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PointInCircleCheckerTest {

    private String runMain(String input) throws Exception {
        InputStream oldInput = System.in;
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outBytes));
            PointInCircleChecker.main(new String[0]);
        } finally {
            System.setIn(oldInput);
            System.setOut(oldOutput);
        }
        return outBytes.toString();
    }

    @Test
    void insideCase() throws Exception {
        // radius = 10, center 0 0, point 4 5 => inside
        String out = runMain("10\n0 0\n4 5\n");
        assertTrue(out.contains("is in the circle"), () -> "Output: " + out);
    }

    @Test
    void outsideCase() throws Exception {
        // radius = 10, center 0 0, point 9 9 => outside
        String out = runMain("10\n0 0\n9 9\n");
        assertTrue(out.contains("is not in the circle"), () -> "Output: " + out);
    }

    @Test
    void badInputThenSucceed() throws Exception {
        String feed =
                "\n" + //Radius test
                "x\nx y\n0 0\n-2\n10\n" +
                "\n" + //Center test
                "x\nx y\n-3\n8\n0 0\n" +
                "\n" + //Point test
                "x\nx y\n-3\n9\n4 5\n";
        String out = runMain(feed);
        assertTrue(out.contains("Point (4.0, 5.0) is in the circle"), () -> "Output: " + out);
    }

}