package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class BusTest {
    private Transport bus;
    static private Human human;
    static private Policeman policeman;
    static private Fireman fireman;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BusTest.class started");
        human = new Human("Test", "Test");
        policeman = new Policeman("Test", "Test", 1);
        fireman = new Fireman("Test", "Test", 1);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("BusTest.class finished");
    }

    @Before
    public void initTest() {
        bus = new Bus();
    }

    @After
    public void afterTest() {
        bus = null;
    }

    @Test
    public void addHumanPassenger() throws FullTransportException {
        bus.addPassenger(human);
        assertEquals(1, bus.numberOfOccupiedSeats);
    }

    @Test
    public void addPolicemanPassenger() throws FullTransportException {
        bus.addPassenger(policeman);
        assertEquals(1, bus.numberOfOccupiedSeats);
    }

    @Test
    public void addFiremanPassenger() throws FullTransportException {
        bus.addPassenger(fireman);
        assertEquals(1, bus.numberOfOccupiedSeats);
    }

    @Test(expected = FullTransportException.class)
    public void overflowByPassengers() throws FullTransportException {
        int maxSeats = Bus.getNumberOfSeats();
        for (int i = 0; i <= maxSeats; i++) {
            bus.addPassenger(human);
            if (i == maxSeats - 1) assertEquals(maxSeats, bus.numberOfOccupiedSeats);
        }
    }

    @Test
    public void removeExistingPassenger() throws FullTransportException, RemoveNotExistingPassengerException {
        bus.addPassenger(human);
        bus.removePassenger(human);
    }

    @Test(expected = RemoveNotExistingPassengerException.class)
    public void removeNotExistingPassenger() throws RemoveNotExistingPassengerException {
        bus.removePassenger(human);
    }
}