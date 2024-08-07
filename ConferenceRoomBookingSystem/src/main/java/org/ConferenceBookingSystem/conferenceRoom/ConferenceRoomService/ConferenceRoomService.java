package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomService;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;

public interface ConferenceRoomService {

    void addRoom(String name, TimeSlot slot, int capacity);

    void updateRoom(String name, TimeSlot slot, int capacity);

    void removeRoom(String name);
}
