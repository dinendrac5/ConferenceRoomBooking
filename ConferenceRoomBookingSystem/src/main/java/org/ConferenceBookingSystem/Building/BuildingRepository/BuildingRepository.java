package org.ConferenceBookingSystem.Building.BuildingRepository;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class BuildingRepository implements IBuildingRepository {
    @Override
    public List<ConferenceRoom> findById(int id) {
        return List.of();
    }
}
