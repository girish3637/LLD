package service;

import manager.MeetingInvitee;
import manager.MeetingNotifier;
import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class BookingManager {
    private static BookingManager instance;
    private List<MeetingRoom> meetingRooms;
    private List<Meeting> meetingHistory;
    private MeetingNotifier notifier;

    private BookingManager(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
        this.meetingHistory = new ArrayList<>();
        this.notifier = new MeetingNotifier();
    }

    public static BookingManager getInstance(List<MeetingRoom> meetingRooms) {
        if (instance == null) {
            instance = new BookingManager(meetingRooms);
        }
        return instance;
    }

    public boolean isRoomAvailable(MeetingRoom room, LocalDateTime startTime, LocalDateTime endTime) {
        for (Meeting meeting : meetingHistory) {
            if (meeting.getRoom().equals(room) &&
                    ((startTime.isBefore(meeting.getEndTime()) && startTime.isAfter(meeting.getStartTime())) ||
                            (endTime.isAfter(meeting.getStartTime()) && endTime.isBefore(meeting.getEndTime())))) {
                return false;
            }
        }
        return true;
    }

    public String bookMeeting(LocalDateTime startTime, LocalDateTime endTime, List<String> invitees) {
        for (MeetingRoom room : meetingRooms) {
            if (isRoomAvailable(room, startTime, endTime)) {
                Meeting meeting = new Meeting(meetingHistory.size() + 1, room, startTime, endTime, invitees);
                meetingHistory.add(meeting);
                sendNotification(meeting);
                return "Meeting booked in room: " + room.getRoomName();
            }
        }
        return "No room available at the given time.";
    }

    private void sendNotification(Meeting meeting) {
        for (String invitee : meeting.getInvitees()) {
            notifier.addObserver(new MeetingInvitee(invitee));  // Adding invitee as an observer
        }
        notifier.notifyObservers(meeting);  // Send notifications to all invitees
    }

    public List<Meeting> getLast20Meetings() {
        int start = Math.max(0, meetingHistory.size() - 20);
        return meetingHistory.subList(start, meetingHistory.size());
    }
}