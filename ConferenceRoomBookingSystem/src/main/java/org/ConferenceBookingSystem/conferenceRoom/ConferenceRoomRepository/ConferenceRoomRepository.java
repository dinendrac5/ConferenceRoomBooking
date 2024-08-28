package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository;

import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConferenceRoomRepository implements IConferenceRoomRepository {
    private final List<ConferenceRoom> confRooms;

    public ConferenceRoomRepository() {
        confRooms = new ArrayList<>();
    }

    @Override
    public ConferenceRoom findById(int id) {
        return confRooms.stream().filter(conferenceRoom -> conferenceRoom.getId() == id).findFirst().orElse(null);
    }

    @Override
    public ConferenceRoom findByBookedSlot(TimeSlot slot) {
        return confRooms.stream().filter(conferenceRoom -> Objects.equals(conferenceRoom.getBookedSlot(), slot)).findAny().orElse(null);
    }

    @Override
    public void addRoom(ConferenceRoom conferenceRoom) {
        confRooms.add(conferenceRoom);
    }

    @Override
    public void updateRoom(ConferenceRoom conferenceRoom) {
        for (int i = 0; i <= confRooms.size(); i++) {
            if (confRooms.get(i).getId() == conferenceRoom.getId()) {
                confRooms.set(i, conferenceRoom);
            }
        }
    }

    @Override
    public void deleteRoom(int id) {
        confRooms.removeIf(conferenceRoom -> conferenceRoom.getId() == id);
    }

}
