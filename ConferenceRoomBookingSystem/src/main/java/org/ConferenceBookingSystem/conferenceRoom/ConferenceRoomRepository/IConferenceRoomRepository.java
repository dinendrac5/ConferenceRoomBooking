package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public interface IConferenceRoomRepository {

    ConferenceRoom findById(int id);

    List<ConferenceRoom> findByBookedSlot(TimeSlot bookedSlot);

}
