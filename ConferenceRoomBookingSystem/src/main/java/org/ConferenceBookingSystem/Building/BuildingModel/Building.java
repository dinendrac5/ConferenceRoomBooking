package org.ConferenceBookingSystem.Building.BuildingModel;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class Building {

    int buildingId;

    String buildingName;

    List<Floor> floors;

    List<ConferenceRoom> confRooms;

    public Building(int buildingId, String buildingName, List<Floor> floors, List<ConferenceRoom> confRooms) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.floors = floors;
        this.confRooms = confRooms;
    }
}
