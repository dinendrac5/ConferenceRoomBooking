package org.ConferenceBookingSystem.Building.BuildingService;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Building.BuildingRepository.BuildingRepository;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;

public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Building addBuilding(Building building) {
        Building savedBuilding = buildingRepository.findById(building.getBuildingId());
        if (savedBuilding != null) {
            throw new UnsupportedOperationException("Building already exists");
        }
        Building newBuilding = new Building();
        newBuilding.setBuildingId(building.getBuildingId());
        newBuilding.setBuildingName(building.getBuildingName());
        newBuilding.setBuildingAddress(building.getBuildingAddress());
        buildingRepository.addBuilding(newBuilding);
        return newBuilding;
    }

    @Override
    public Building updateBuilding(Building building) throws EntityNotFound {
        Building savedBuilding = buildingRepository.findById(building.getBuildingId());
        if (savedBuilding == null) {
            throw new EntityNotFound("Building does not exists");
        }
        buildingRepository.updateBuilding(building);
        return null;
    }

    @Override
    public String removeBuilding(Building building) {
        buildingRepository.removeBuilding(building.getBuildingId());
        return "";
    }
}
