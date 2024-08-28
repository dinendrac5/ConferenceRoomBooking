package org.ConferenceBookingSystem.Booking.BookingService;

import org.ConferenceBookingSystem.Booking.BookingModel.Booking;
import org.ConferenceBookingSystem.Booking.BookingModel.BookingStatus;
import org.ConferenceBookingSystem.Booking.BookingRepository.BookingRepository;
import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Building.BuildingRepository.BuildingRepository;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.*;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.Floor.FloorRepository.FloorRepository;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository.ConferenceRoomRepository;
import org.ConferenceBookingSystem.user.UserModel.User;
import org.ConferenceBookingSystem.user.UserRepository.UserRepository;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final BuildingRepository buildingRepository;

    private final FloorRepository floorRepository;

    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ConferenceRoomRepository conferenceRoomRepository, UserRepository userRepository, BuildingRepository buildingRepository, FloorRepository floorRepository) {
        this.bookingRepository = bookingRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.buildingRepository = buildingRepository;
        this.floorRepository = floorRepository;
        this.userRepository = userRepository;
    }

    /**
     * validate the booking details given by user and save the booking to repository
     *
     * @param booking booking object
     */
    @Override
    public Booking createNewBooking(Booking booking) throws UserException, EntityNotFound {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(booking.getConfRoom().getId());
        if (conferenceRoom == null) {
            throw new NotFoundCID("room does not exist");
        }
        validateBooking(booking);
        Booking savedBooking = bookingRepository.findById(booking.getBookingId());
        if (savedBooking != null) {
            throw new BookingExistsException("Booking Already exists for booking Id: " + booking.getBookingId());
        }
        Booking newBooking = mapFields(booking);
        bookingRepository.createBooking(newBooking);
        //set booked slot for conference room
        conferenceRoom.setBookedSlot(List.of(newBooking.getSlot()));
        newBooking.setBookingStatus(BookingStatus.ACTIVE);
        return newBooking;
    }

    /**
     * check if user exists
     * check if building exists in repo
     * check if floor exists in the building
     * check if room exists in floor
     * check if capacity exists
     * check if time slot exists for the room
     *
     * @param booking booking object
     */
    private void validateBooking(Booking booking) throws UserException, EntityNotFound {
        //check if room exists in the provided floor and floor exists in the provided building
        boolean slotBooked = false;
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(booking.getConfRoom().getId());
        if (conferenceRoom.getBookedSlot() != null) {
            slotBooked = conferenceRoom.getBookedSlot().stream().anyMatch(slot -> slot.equals(booking.getSlot()));
        }
        User user = userRepository.findById(booking.getUser().getId());
        if (user == null) {
            throw new UserNotFoundException("User does not exists For the provided booking Id: " + booking.getBookingId());
        }
        Building building = buildingRepository.findById(booking.getBuilding().getBuildingId());
        if (building == null) {
            throw new EntityNotFound("Building doesn't exists with provided building id: " + booking.getBuilding().getBuildingId());
        }
        Floor floor = floorRepository.findByFloorIdAndBuildingId(booking.getFloor().getFloorId(), booking.getBuilding().getBuildingId());
        if (floor == null) {
            throw new EntityNotFound("Floor does not belong to the providing building");
        }
        if (conferenceRoom.getFloor() != null && conferenceRoom.getFloor().getFloorId() != booking.getFloor().getFloorId()) {
            throw new NotFoundCID("Provided Room does not exists in the floor");
        }
        if (booking.getConfRoom().getCapacity() <= conferenceRoom.getCapacity()) {
            throw new NotFoundCID("Room can't hold this capacity");
        }
        if (slotBooked) {
            throw new BookingExistsException("Provided Room already booked with given time slot: " + booking.getSlot());
        }
    }

    @Override
    public Booking updateBooking(Booking booking) throws UserException, EntityNotFound {
        Booking savedBooking = bookingRepository.findById(booking.getBookingId());
        if (savedBooking == null) {
            throw new NotFoundCID("Booking Does not exists");
        }
        validateBooking(booking);
        Booking updatedBooking = mapFields(savedBooking);
        bookingRepository.updateBooking(updatedBooking);
        return updatedBooking;
    }

    private Booking mapFields(Booking booking) {
        Booking newBooking = new Booking();
        newBooking.setBookingId(booking.getBookingId());
        newBooking.setUser(booking.getUser());
        newBooking.setBuilding(booking.getBuilding());
        newBooking.setFloor(booking.getFloor());
        newBooking.setConfRoom(booking.getConfRoom());
        newBooking.setSlot(booking.getSlot());
        return newBooking;
    }

    @Override
    public void deleteBooking(int id) throws EntityNotFound {
        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            throw new EntityNotFound("Booking Does not exists for id: " + id);
        }
        bookingRepository.deleteBooking(id);
    }
}
