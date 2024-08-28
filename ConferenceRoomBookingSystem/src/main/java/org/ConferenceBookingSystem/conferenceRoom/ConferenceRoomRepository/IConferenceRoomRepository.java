package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

public interface IConferenceRoomRepository {

    ConferenceRoom findById(int id);

    ConferenceRoom findByBookedSlot(TimeSlot bookedSlot);

    void addRoom(ConferenceRoom conferenceRoom);

    void updateRoom(ConferenceRoom conferenceRoom);

    void deleteRoom(int id);

}
