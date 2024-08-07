package org.ConferenceBookingSystem.Floor.FloorModel;

import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

public class Floor {

    int floorId; //floor number

    ConferenceRoom conferenceRoom; // all the conference rooms in the floor

    public Floor(int floorId, ConferenceRoom conferenceRoom) {
        this.floorId = floorId;
        this.conferenceRoom = conferenceRoom;
    }

}
