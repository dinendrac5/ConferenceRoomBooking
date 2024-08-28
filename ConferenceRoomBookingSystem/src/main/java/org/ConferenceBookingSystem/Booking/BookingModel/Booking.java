package org.ConferenceBookingSystem.Booking.BookingModel;

import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.user.UserModel.User;

public class Booking {

    int bookingId;

    User user;

    Building building;

    Floor floor;

    ConferenceRoom confRoom;

    TimeSlot slot;

    BookingStatus bookingStatus;


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public ConferenceRoom getConfRoom() {
        return confRoom;
    }

    public void setConfRoom(ConferenceRoom confRoom) {
        this.confRoom = confRoom;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
