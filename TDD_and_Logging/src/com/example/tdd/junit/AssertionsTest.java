package com.example.tdd.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3, "Arithmetic sum check failed");

        // Assert true
        assertTrue(5 > 3, "Comparison check failed");

        // Assert false
        assertFalse(5 < 3, "Reverse comparison check failed");

        // Assert null
        assertNull(null, "Null value check failed");

        // Assert not null
        assertNotNull(new Object(), "Non-null object check failed");
    }
}
