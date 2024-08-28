package org.ConferenceBookingSystem.Floor.FloorService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;

public interface FloorService {
    Floor addFloor(Floor floor);

    Floor updateFloor(Floor floor) throws EntityNotFound;

    String removeFloor(int floorId);
}
