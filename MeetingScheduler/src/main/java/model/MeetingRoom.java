package model;

public class MeetingRoom {
    private int roomId;
    private String roomName;

    public MeetingRoom(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }
}