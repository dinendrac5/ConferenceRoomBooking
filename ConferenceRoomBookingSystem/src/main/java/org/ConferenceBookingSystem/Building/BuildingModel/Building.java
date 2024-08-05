package org.ConferenceBookingSystem.Building.BuildingModel;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;

import java.util.List;

public class Building {
    int buildingId;
    String buildingName;
    List<Floor> floors;

    public Building(int buildingId, String buildingName, List<Floor> floors) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.floors = floors;
    }
}
