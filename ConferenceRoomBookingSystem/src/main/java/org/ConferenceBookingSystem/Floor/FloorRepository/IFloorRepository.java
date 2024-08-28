package org.ConferenceBookingSystem.Floor.FloorRepository;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;

import java.util.List;

public interface IFloorRepository {

    Floor findByFloorIdAndBuildingId(int floorId, int buildingId);

    List<Floor> getAllFloors();

    void addFloor(Floor floor);

    void updateFloor(Floor floor);

    void removeFloor(int id);


}
