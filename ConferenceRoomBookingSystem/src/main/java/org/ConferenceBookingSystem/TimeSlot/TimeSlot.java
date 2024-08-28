package org.ConferenceBookingSystem.TimeSlot;

import java.time.LocalTime;

public class TimeSlot {

    LocalTime startTime;

    LocalTime endTime;

    public TimeSlot(LocalTime start_time, LocalTime end_time) {
        this.startTime = start_time;
        this.endTime = end_time;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public TimeSlot() {
    }


}
