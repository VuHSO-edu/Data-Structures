package Hw5_22000132_NguyenDuyVu.BaiTap3;

public class Event implements Comparable<Event> {
    private int timestamp;
    private String description;

    public Event(int timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "Event{" +
                "timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}
