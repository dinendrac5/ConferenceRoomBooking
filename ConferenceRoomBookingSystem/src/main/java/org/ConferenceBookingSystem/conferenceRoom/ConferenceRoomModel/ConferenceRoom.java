package org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel;

import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;

import java.util.List;

public class ConferenceRoom {

    private int id;     //conferenceRoom id

    private String name;  //conferenceRoom Name

    private int capacity; //max members that can be accommodated

    private List<TimeSlot> bookedSlot; //if the room is booked already

    private Floor floor;

    public ConferenceRoom(int id, String name, int capacity, List<TimeSlot> bookedSlot, Floor floor) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.bookedSlot = bookedSlot;
        this.floor = floor;
    }

    public ConferenceRoom() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<TimeSlot> getBookedSlot() {
        return bookedSlot;
    }

    public void setBookedSlot(List<TimeSlot> bookedSlot) {
        this.bookedSlot = bookedSlot;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
