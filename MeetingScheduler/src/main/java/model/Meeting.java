package model;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private int meetingId;
    private MeetingRoom room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> invitees;

    public Meeting(int meetingId, MeetingRoom room, LocalDateTime startTime, LocalDateTime endTime, List<String> invitees) {
        this.meetingId = meetingId;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.invitees = invitees;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<String> getInvitees() {
        return invitees;
    }
}