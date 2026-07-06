package com.example.tdd.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AAATest {
    private List<String> list;

    @BeforeEach
    public void setUp() {
        // Setup (Arrange): Initialize resources
        list = new ArrayList<>();
        System.out.println("Setup phase: List initialized.");
    }

    @AfterEach
    public void tearDown() {
        // Cleanup (Tear down): Release/reset resources
        list.clear();
        list = null;
        System.out.println("Teardown phase: List cleared.");
    }

    @Test
    public void testListAddition() {
        // Arrange
        String item = "JUnit5";

        // Act
        list.add(item);

        // Assert
        assertEquals(1, list.size(), "List size must be 1 after addition");
        assertEquals("JUnit5", list.get(0), "Retrieved element must match added item");
    }
}
