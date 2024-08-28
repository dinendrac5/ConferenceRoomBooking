package org.ConferenceBookingSystem.Floor.FloorModel;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;

public class Floor {

    private int floorId; //floor number

    private String floorName;

    private Building building;

    public Floor() {

    }

    public Floor(int floorId, String floorName, Building building) {
        this.floorId = floorId;
        this.floorName = floorName;
        this.building = building;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }


}
