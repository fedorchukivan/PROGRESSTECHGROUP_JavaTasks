package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class PoliceCarTest {
    private Transport policeCar;
    static private Human human;
    static private Policeman policeman;
    static private Fireman fireman;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("PoliceCarTest.class started");
        human = new Human("Test", "Test");
        policeman = new Policeman("Test", "Test", 1);
        fireman = new Fireman("Test", "Test", 1);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("PoliceCarTest.class finished");
    }

    @Before
    public void initTest() {
        policeCar = new PoliceCar();
    }

    @After
    public void afterTest() {
        policeCar = null;
    }

    @Test(expected = ClassCastException.class)
    public void addHumanPassenger() throws FullTransportException, ClassCastException {
        policeCar.addPassenger(human);
    }

    @Test
    public void addPolicemanPassenger() throws FullTransportException {
        policeCar.addPassenger(policeman);
        assertEquals(1, policeCar.numberOfOccupiedSeats);
    }

    @Test(expected = ClassCastException.class)
    public void addFiremanPassenger() throws FullTransportException, ClassCastException {
        policeCar.addPassenger(fireman);
    }

    @Test(expected = FullTransportException.class)
    public void overflowByPassengers() throws FullTransportException {
        int maxSeats = PoliceCar.getNumberOfSeats();
        for (int i = 0; i <= maxSeats; i++) {
            policeCar.addPassenger(policeman);
            if (i == maxSeats - 1) assertEquals(maxSeats, policeCar.numberOfOccupiedSeats);
        }
    }

    @Test
    public void removeExistingPassenger() throws FullTransportException, RemoveNotExistingPassengerException {
        policeCar.addPassenger(policeman);
        policeCar.removePassenger(policeman);
    }

    @Test(expected = RemoveNotExistingPassengerException.class)
    public void removeNotExistingPassenger() throws RemoveNotExistingPassengerException {
        policeCar.removePassenger(policeman);
    }
}