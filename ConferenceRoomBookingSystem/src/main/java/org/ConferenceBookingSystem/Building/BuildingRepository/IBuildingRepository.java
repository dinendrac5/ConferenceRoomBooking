package org.ConferenceBookingSystem.Building.BuildingRepository;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;

public interface IBuildingRepository {
    Building findById(int id);//id refers to building id

    //search, add, remove.

    //add floor and conference rooms repo methods under building repo
    void addBuilding(Building building);

    void removeBuilding(int id);

    void updateBuilding(Building building);
}
