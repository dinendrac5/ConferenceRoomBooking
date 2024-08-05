package org.ConferenceBookingSystem.Floor.FloorModel;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class Floor {

    int floorId; //floor number

    List<ConferenceRoom> conferenceRooms; // all the conference rooms in the floor

    public Floor(int floorId, List<ConferenceRoom> conferenceRooms) {
        this.floorId = floorId;
        this.conferenceRooms = conferenceRooms;
    }

}
