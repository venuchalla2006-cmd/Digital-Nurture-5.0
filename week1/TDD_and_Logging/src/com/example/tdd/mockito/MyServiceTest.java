package com.example.tdd.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Exercise 1: Mocking and Stubbing
        // Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Stub method call
        when(mockApi.getData()).thenReturn("Mock Data");

        // Use mock
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert correctness
        assertEquals("Mock Data", result, "Fetch data return mismatch");
    }

    @Test
    public void testVerifyInteraction() {
        // Exercise 2: Verifying Interactions
        // Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Use mock
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Verify that the mock's method was actually called
        verify(mockApi, times(1)).getData();
    }
}
