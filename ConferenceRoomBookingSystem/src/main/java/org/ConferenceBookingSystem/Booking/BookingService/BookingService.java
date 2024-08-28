package org.ConferenceBookingSystem.Booking.BookingService;

import org.ConferenceBookingSystem.Booking.BookingModel.Booking;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.UserException;

public interface BookingService {

    Booking createNewBooking(Booking booking) throws UserException, EntityNotFound;

    Booking updateBooking(Booking booking) throws UserException, EntityNotFound;

    void deleteBooking(int id) throws EntityNotFound;
}
