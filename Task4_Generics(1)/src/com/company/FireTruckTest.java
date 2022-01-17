package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class FireTruckTest {
    private Transport fireTruck;
    static private Human human;
    static private Policeman policeman;
    static private Fireman fireman;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("FireTruckTest.class started");
        human = new Human("Test", "Test");
        policeman = new Policeman("Test", "Test", 1);
        fireman = new Fireman("Test", "Test", 1);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("FireTruckTest.class finished");
    }

    @Before
    public void initTest() {
        fireTruck = new FireTruck();
    }

    @After
    public void afterTest() {
        fireTruck = null;
    }

    @Test(expected = ClassCastException.class)
    public void addHumanPassenger() throws FullTransportException, ClassCastException {
        fireTruck.addPassenger(human);
    }

    @Test(expected = ClassCastException.class)
    public void addPolicemanPassenger() throws FullTransportException, ClassCastException {
        fireTruck.addPassenger(policeman);
    }

    @Test
    public void addFiremanPassenger() throws FullTransportException {
        fireTruck.addPassenger(fireman);
        assertEquals(1, fireTruck.numberOfOccupiedSeats);
    }

    @Test(expected = FullTransportException.class)
    public void overflowByPassengers() throws FullTransportException {
        int maxSeats = FireTruck.getNumberOfSeats();
        for (int i = 0; i <= maxSeats; i++) {
            fireTruck.addPassenger(fireman);
            if (i == maxSeats - 1) assertEquals(maxSeats, fireTruck.numberOfOccupiedSeats);
        }
    }

    @Test
    public void removeExistingPassenger() throws FullTransportException, RemoveNotExistingPassengerException {
        fireTruck.addPassenger(fireman);
        fireTruck.removePassenger(fireman);
    }

    @Test(expected = RemoveNotExistingPassengerException.class)
    public void removeNotExistingPassenger() throws RemoveNotExistingPassengerException {
        fireTruck.removePassenger(fireman);
    }
}