package manager;

import model.MeetingRoom;

class MeetingRoomFactory {
    public static MeetingRoom createMeetingRoom(int roomId, String roomName) {
        return new MeetingRoom(roomId, roomName);
    }
}
