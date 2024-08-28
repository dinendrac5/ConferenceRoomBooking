package org.ConferenceBookingSystem.Building.BuildingModel;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class Building {

    private int buildingId;

    private String buildingName;

    private String buildingAddress;

    public Building() {

    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }


    public Building(int buildingId, String buildingName, List<ConferenceRoom> confRooms, String buildingAddress) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
    }
}
