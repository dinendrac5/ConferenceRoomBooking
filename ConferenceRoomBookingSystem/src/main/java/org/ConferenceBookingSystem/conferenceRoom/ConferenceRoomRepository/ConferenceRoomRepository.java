package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.List;

public class ConferenceRoomRepository implements IConferenceRoomRepository {
    @Override
    public ConferenceRoom findById(int id) {
        return null;
    }

    @Override
    public List<ConferenceRoom> findByBookedSlot(TimeSlot bookedSlot) {
        return List.of();
    }
    
}
