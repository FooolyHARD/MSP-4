package com.senechka.lab3.tests;

import com.senechka.lab3.beans.Coordinates;
import com.senechka.lab3.db.HitResult;
import com.senechka.lab3.beans.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @Test
    void testProcessRequestWithValidCoordinates() {
        Coordinates validCoordinates = new Coordinates(1, 1);
        HitResult hitResult = service.processRequest("session123", validCoordinates);

        // Verify that hitResult is not null
        assertNotNull(hitResult);

        // Verify that the hitResult coordinates are the same as the provided validCoordinates
        assertEquals(validCoordinates, hitResult.getCoordinates());
    }

    @Test
    void testProcessRequestWithInvalidCoordinates() {
        Coordinates invalidCoordinates = new Coordinates(10, 10);
        HitResult hitResult = service.processRequest("session123", invalidCoordinates);

        // Verify that hitResult is null since the coordinates are invalid
        assertNull(hitResult);
    }

    @Test
    void testGetUserHitsWithValidSessionId() {
        String sessionId = "session123";
        LinkedList<HitResult> userHits = service.getUserHits(sessionId);

        // Verify that the userHits list is not null
        assertNotNull(userHits);

        // Verify that the userHits list is empty since there are no hits for the provided sessionId
        assertTrue(userHits.isEmpty());
    }

    @Test
    void testGetUserHitsWithInvalidSessionId() {
        String sessionId = null;
        LinkedList<HitResult> userHits = service.getUserHits(sessionId);

        // Verify that the userHits list is not null
        assertNotNull(userHits);

        // Verify that the userHits list is empty since the sessionId is null
        assertTrue(userHits.isEmpty());
    }

    @Test
    void testClearUserHits() {
        String sessionId = "session123";

        // Add some dummy hit results for the sessionId
        service.processRequest(sessionId, new Coordinates(1, 1));
        service.processRequest(sessionId, new Coordinates(2, 2));
        service.processRequest(sessionId, new Coordinates(3, 3));

        // Clear the user hits for the sessionId
        service.clearUserHits(sessionId);

        // Verify that the user hits list is empty after clearing
        LinkedList<HitResult> userHits = service.getUserHits(sessionId);
        assertNotNull(userHits);
        assertTrue(userHits.isEmpty());
    }
}