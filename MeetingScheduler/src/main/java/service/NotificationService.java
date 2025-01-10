package service;

import model.Meeting;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendMeetingNotification(Meeting meeting) {
        System.out.println("Notification for meeting " + meeting.getMeetingId() + " sent to attendees: " + meeting.getInvitees());
    }
}