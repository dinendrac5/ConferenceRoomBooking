package org.ConferenceBookingSystem.Building.BuildingService;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;

public interface BuildingService {
    Building addBuilding(Building building);

    Building updateBuilding(Building building) throws EntityNotFound;

    String removeBuilding(Building building);
}
