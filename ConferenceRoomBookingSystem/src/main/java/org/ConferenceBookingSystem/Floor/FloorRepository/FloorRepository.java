package org.ConferenceBookingSystem.Floor.FloorRepository;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class FloorRepository implements IFloorRepository {

    @Override
    public List<ConferenceRoom> findById(int id) {
        return List.of();
    }
}
