package org.ConferenceBookingSystem.Floor.FloorService;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public interface FloorService {
    void addFloor(int floorId, List<ConferenceRoom> confRooms);

    void updateFloor(int floorId, List<ConferenceRoom> confRooms);

    void removeFloor(int floorId);
}
