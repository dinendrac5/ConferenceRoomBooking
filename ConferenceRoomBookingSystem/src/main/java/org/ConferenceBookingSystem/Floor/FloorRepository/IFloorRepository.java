package org.ConferenceBookingSystem.Floor.FloorRepository;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public interface IFloorRepository {

    List<ConferenceRoom> findById(int id);
}
