package manager;

import model.Meeting;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(Meeting meeting);
}

// Concrete Observer
public class MeetingInvitee implements Observer {
    private String name;

    public MeetingInvitee(String name) {
        this.name = name;
    }

    @Override
    public void update(Meeting meeting) {
        System.out.println("Notification to " + name + ": Meeting scheduled in " + meeting.getRoom().getRoomName());
    }
}

// Subject (Publisher)
public class MeetingNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Meeting meeting) {
        for (Observer observer : observers) {
            observer.update(meeting);
        }
    }
}
