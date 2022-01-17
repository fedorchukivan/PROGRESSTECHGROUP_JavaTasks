package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class TaxiTest {
    private Transport taxi;
    static private Human human;
    static private Policeman policeman;
    static private Fireman fireman;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("TaxiTest.class started");
        human = new Human("Test", "Test");
        policeman = new Policeman("Test", "Test", 1);
        fireman = new Fireman("Test", "Test", 1);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("TaxiTest.class finished");
    }

    @Before
    public void initTest() {
        taxi = new Taxi();
    }

    @After
    public void afterTest() {
        taxi = null;
    }

    @Test
    public void addHumanPassenger() throws FullTransportException {
        taxi.addPassenger(human);
        assertEquals(1, taxi.numberOfOccupiedSeats);
    }

    @Test
    public void addPolicemanPassenger() throws FullTransportException {
        taxi.addPassenger(policeman);
        assertEquals(1, taxi.numberOfOccupiedSeats);
    }

    @Test
    public void addFiremanPassenger() throws FullTransportException {
        taxi.addPassenger(fireman);
        assertEquals(1, taxi.numberOfOccupiedSeats);
    }

    @Test(expected = FullTransportException.class)
    public void overflowByPassengers() throws FullTransportException {
        int maxSeats = Taxi.getNumberOfSeats();
        for (int i = 0; i <= maxSeats; i++) {
            taxi.addPassenger(human);
            if (i == maxSeats - 1) assertEquals(maxSeats, taxi.numberOfOccupiedSeats);
        }
    }

    @Test
    public void removeExistingPassenger() throws FullTransportException, RemoveNotExistingPassengerException {
        taxi.addPassenger(human);
        taxi.removePassenger(human);
    }

    @Test(expected = RemoveNotExistingPassengerException.class)
    public void removeNotExistingPassenger() throws RemoveNotExistingPassengerException {
        taxi.removePassenger(human);
    }
}