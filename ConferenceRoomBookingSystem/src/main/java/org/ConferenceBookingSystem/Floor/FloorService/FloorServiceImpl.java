package org.ConferenceBookingSystem.Floor.FloorService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.Floor.FloorRepository.FloorRepository;

public class FloorServiceImpl implements FloorService {
    private final FloorRepository floorRepository;

    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public Floor addFloor(Floor floor) {
        Floor savedFloor = floorRepository.findByFloorIdAndBuildingId(floor.getFloorId(), floor.getBuilding().getBuildingId());
        if (savedFloor != null) {
            throw new UnsupportedOperationException("floor already exists");
        }
        Floor newFloor = new Floor();
        newFloor.setFloorId(floor.getFloorId());
        newFloor.setFloorName(floor.getFloorName());
        newFloor.setBuilding(floor.getBuilding());
        floorRepository.addFloor(newFloor);
        return newFloor;
    }

    @Override
    public Floor updateFloor(Floor floor) throws EntityNotFound {
        Floor savedFloor = floorRepository.findByFloorIdAndBuildingId(floor.getFloorId(), floor.getBuilding().getBuildingId());
        if (savedFloor == null) {
            throw new EntityNotFound("Floor not found");
        }
        floorRepository.updateFloor(floor);
        return null;
    }

    @Override
    public String removeFloor(int floorId) {
        floorRepository.removeFloor(floorId);
        return "";
    }
}
