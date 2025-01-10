package service;

import model.Meeting;

import java.util.List;

class HistoryManager {
    private static HistoryManager instance;
    private BookingManager bookingManager;

    private HistoryManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public static HistoryManager getInstance(BookingManager bookingManager) {
        if (instance == null) {
            instance = new HistoryManager(bookingManager);
        }
        return instance;
    }

    public List<Meeting> getHistory() {
        return bookingManager.getLast20Meetings();
    }
}
