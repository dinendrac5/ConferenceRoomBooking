package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;

public class ConferenceRoom {

    int id;     //conferenceRoom id

    String name;  //conferenceRoom Name

    int capacity; //max members that can be accommodated

    TimeSlot slot;

    TimeSlot bookedSlot;

    public ConferenceRoom(int id, String name, int capacity, TimeSlot slot, TimeSlot bookedSlot) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.slot = slot;
        this.bookedSlot = bookedSlot;
    }
}
