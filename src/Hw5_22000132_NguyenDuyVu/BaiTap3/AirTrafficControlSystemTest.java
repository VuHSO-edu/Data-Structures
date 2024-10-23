package Hw5_22000132_NguyenDuyVu.BaiTap3;

public class AirTrafficControlSystemTest {
    public static void main(String[] args) {
        AirTrafficControlSystem atcs = new AirTrafficControlSystem();

        // Adding events
        atcs.addEvent(10, "Plane A landing");
        atcs.addEvent(5, "Plane B takeoff");
        atcs.addEvent(15, "Plane C landing");
        atcs.addEvent(7, "Plane D takeoff");

        // Retrieving events
        while (atcs.hasEvents()) {
            Event nextEvent = atcs.getNextEvent();
            System.out.println("Next event: " + nextEvent);
        }
    }
}
