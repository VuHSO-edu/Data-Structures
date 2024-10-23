package Hw5_22000132_NguyenDuyVu.BaiTap3;

import Hw5_22000132_NguyenDuyVu.BaiTap1.PriorityQueueInterface;
import Hw5_22000132_NguyenDuyVu.BaiTap1.UnsortedArrayPriorityQueue;

public class AirTrafficControlSystem {
    private PriorityQueueInterface<Integer, Event> eventQueue;

    public AirTrafficControlSystem() {
        eventQueue = new UnsortedArrayPriorityQueue<>();
    }

    public void addEvent(int timestamp, String description) {
        Event event = new Event(timestamp, description);
        eventQueue.insert(timestamp, event);
    }

    public Event getNextEvent() {
        if (eventQueue.isEmpty()) {
            return null;
        }
        return eventQueue.removeMin().getValue();
    }

    public boolean hasEvents() {
        return !eventQueue.isEmpty();
    }
}
