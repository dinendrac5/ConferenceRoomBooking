package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.NotFoundCID;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;

public interface ConferenceRoomService {

    ConferenceRoom addRoom(ConferenceRoom conferenceRoom) throws NotFoundCID;

    ConferenceRoom updateRoom(ConferenceRoom conferenceRoom) throws EntityNotFound, NotFoundCID;

    void removeRoom(int id);
}
