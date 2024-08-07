package org.ConferenceBookingSystem.Building.BuildingService;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public interface BuildingService {
    void addBuilding(String buildingName, List<Floor> floorList, List<ConferenceRoom> confRooms);

    void removeBuilding(String buildingName);
}
