package org.ConferenceBookingSystem.Building.BuildingRepository;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public interface IBuildingRepository {
    List<ConferenceRoom> findById(int id);//id refers to building id

}
