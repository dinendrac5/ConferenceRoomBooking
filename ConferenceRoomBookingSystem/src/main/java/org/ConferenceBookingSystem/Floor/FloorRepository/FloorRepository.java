package org.ConferenceBookingSystem.Floor.FloorRepository;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;

import java.util.ArrayList;
import java.util.List;

public class FloorRepository implements IFloorRepository {
    List<Floor> floors;

    public FloorRepository() {
        this.floors = new ArrayList<>();
    }

    @Override
    public Floor findByFloorIdAndBuildingId(int floorId, int buildingId) {
        return floors.stream().filter(floor -> floor.getFloorId() == floorId && floor.getBuilding().getBuildingId() == buildingId).findFirst().orElse(null);
    }

    @Override
    public List<Floor> getAllFloors() {
        return this.floors;
    }

    @Override
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public void updateFloor(Floor floor) {
        for (int i = 0; i <= floors.size(); i++) {
            if (floors.get(i).getFloorId() == floor.getFloorId()) {
                floors.set(i, floor);
                return;
            }
        }
    }

    @Override
    public void removeFloor(int id) {
        floors.removeIf(floor -> floor.getFloorId() == id);
    }
}
