package org.ConferenceBookingSystem.TimeSlot;

import java.time.LocalTime;

public class TimeSlot {

    LocalTime start_time;

    LocalTime end_time;

    public TimeSlot(LocalTime start_time, LocalTime end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
