package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.NotFoundCID;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository.ConferenceRoomRepository;

public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    private final ConferenceRoomRepository conferenceRoomRepository;

    public ConferenceRoomServiceImpl(ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public ConferenceRoom addRoom(ConferenceRoom conferenceRoom) throws NotFoundCID {
        ConferenceRoom savedRoom = conferenceRoomRepository.findById(conferenceRoom.getId());
        if (savedRoom != null) {
            throw new UnsupportedOperationException("room already exists");
        }
        ConferenceRoom newRoom = new ConferenceRoom();
        newRoom.setId(conferenceRoom.getId());
        newRoom.setName(conferenceRoom.getName());
        newRoom.setCapacity(conferenceRoom.getCapacity());
        newRoom.setFloor(conferenceRoom.getFloor());
        conferenceRoomRepository.addRoom(conferenceRoom);
        return conferenceRoom;
    }

    @Override
    public ConferenceRoom updateRoom(ConferenceRoom conferenceRoom) throws NotFoundCID {
        ConferenceRoom savedRoom = conferenceRoomRepository.findById(conferenceRoom.getId());
        if (savedRoom == null) {
            throw new NotFoundCID("Room not found");
        }
        conferenceRoomRepository.updateRoom(conferenceRoom);
        System.out.println("Room updated successfully");
        return conferenceRoom;
    }

    @Override
    public void removeRoom(int id) {
        conferenceRoomRepository.deleteRoom(id);
        System.out.println("Room deleted successfully");
    }
}
