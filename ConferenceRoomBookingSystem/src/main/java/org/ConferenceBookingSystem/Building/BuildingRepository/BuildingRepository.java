package org.ConferenceBookingSystem.Building.BuildingRepository;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;

import java.util.ArrayList;
import java.util.List;

public class BuildingRepository implements IBuildingRepository {

    private final List<Building> buildings;  //can be done in constructor if required;
    private List<Floor> floors;

    public BuildingRepository() {
        this.buildings = new ArrayList<>();
        this.floors = new ArrayList<>();
    }

    @Override
    public Building findById(int id) {
        return buildings.stream().filter(building -> building.getBuildingId() == id).findFirst().orElse(null);
    }

    @Override
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    @Override
    public void removeBuilding(int id) {
        buildings.removeIf(building -> building.getBuildingId() == id);
    }

    @Override
    public void updateBuilding(Building building) {
        for (int i = 0; i <= buildings.size(); i++) {
            if (buildings.get(i).getBuildingId() == building.getBuildingId()) {
                buildings.set(i, building);
                return;
            }
        }
    }
}
