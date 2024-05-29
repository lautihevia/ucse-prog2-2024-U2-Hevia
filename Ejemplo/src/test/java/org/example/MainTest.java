package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testMain() {
        new Main(); // Instancia la clase Main
        Main.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n");
        assertEquals("Hello world!\n", actualOutput);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}