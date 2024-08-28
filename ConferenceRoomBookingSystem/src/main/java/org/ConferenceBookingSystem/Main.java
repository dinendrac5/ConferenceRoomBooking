package org.ConferenceBookingSystem;


import org.ConferenceBookingSystem.Booking.BookingModel.Booking;
import org.ConferenceBookingSystem.Booking.BookingRepository.BookingRepository;
import org.ConferenceBookingSystem.Booking.BookingService.BookingServiceImpl;
import org.ConferenceBookingSystem.Building.BuildingModel.Building;
import org.ConferenceBookingSystem.Building.BuildingRepository.BuildingRepository;
import org.ConferenceBookingSystem.Building.BuildingService.BuildingServiceImpl;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.EntityNotFound;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.NotFoundCID;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.UserException;
import org.ConferenceBookingSystem.Exceptions.UserExceptions.UserNotFoundException;
import org.ConferenceBookingSystem.Floor.FloorModel.Floor;
import org.ConferenceBookingSystem.Floor.FloorRepository.FloorRepository;
import org.ConferenceBookingSystem.Floor.FloorService.FloorServiceImpl;
import org.ConferenceBookingSystem.TimeSlot.TimeSlot;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomModel.ConferenceRoom;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomRepository.ConferenceRoomRepository;
import org.ConferenceBookingSystem.conferenceRoom.ConferenceRoomService.ConferenceRoomServiceImpl;
import org.ConferenceBookingSystem.user.UserModel.User;
import org.ConferenceBookingSystem.user.UserRepository.UserRepository;
import org.ConferenceBookingSystem.user.UserService.UserServiceImpl;

import java.time.LocalTime;
import java.util.List;

public class Main {

    //Initialize repositories
    private static final UserRepository userRepository = new UserRepository();
    private static final BuildingRepository buildingRepository = new BuildingRepository();
    private static final FloorRepository floorRepository = new FloorRepository();
    private static final ConferenceRoomRepository conferenceRoomRepository = new ConferenceRoomRepository();
    private static final BookingRepository bookingRepository = new BookingRepository();

    //Initialize services
    private static final UserServiceImpl userService = new UserServiceImpl(userRepository);
    private static final BuildingServiceImpl buildingService = new BuildingServiceImpl(buildingRepository);
    private static final FloorServiceImpl floorService = new FloorServiceImpl(floorRepository);
    private static final ConferenceRoomServiceImpl conferenceRoomService = new ConferenceRoomServiceImpl(conferenceRoomRepository);
    private static final BookingServiceImpl bookingService = new BookingServiceImpl(bookingRepository, conferenceRoomRepository, userRepository, buildingRepository, floorRepository);


    public static void main(String[] args) throws UserException {

        //Add user1
        User user1 = new User();
        user1.setId(101);
        user1.setUserName("Dinendra");
        user1.setPassword("Password");
        addUser(user1);
        //Try to add same user
//        User user2 = new User();
//        user2.setId(101);
//        user2.setUserName("Dinendra");
//        user2.setPassword("Password");
//        User createdUser2 = userService.createUser(user2);

        //add multiple users to check the users list
        User user3 = new User();
        user3.setId(102);
        user3.setUserName("admin");
        user3.setPassword("admin");
        addUser(user3);


        //create Building
        Building building1 = new Building();
        building1.setBuildingId(1001);
        building1.setBuildingName("Alpha");
        building1.setBuildingAddress("I-Tech");
        addBuilding(building1);

        Building building2 = new Building();
        building2.setBuildingId(1002);
        building2.setBuildingName("Beta");
        building2.setBuildingAddress("P-Tech");
        addBuilding(building2);


        //create Floor
        Floor floor1 = new Floor();
        floor1.setFloorId(0);
        floor1.setFloorName("Alpha - 1");
        floor1.setBuilding(building1);
        addFloor(floor1);

        Floor floor2 = new Floor();
        floor2.setFloorId(1);
        floor2.setFloorName("Alpha - 2");
        floor2.setBuilding(building1);
        addFloor(floor2);

        Floor floor3 = new Floor();
        floor3.setFloorId(0);
        floor3.setFloorName("Beta - 1");
        floor3.setBuilding(building2);
        addFloor(floor3);

        Floor floor4 = new Floor();
        floor4.setFloorId(1);
        floor4.setFloorName("Beta - 2");
        floor4.setBuilding(building2);
        addFloor(floor4);

        //update floors
        floor1.setFloorName("Alpha - 0");
        try {
            floorService.updateFloor(floor1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        floor2.setFloorName("Alpha - 1");
        try {
            floorService.updateFloor(floor2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getFloorsData();

        //add meeting rooms
        ConferenceRoom conferenceRoom1 = new ConferenceRoom();
        conferenceRoom1.setId(0);
        conferenceRoom1.setName("Room-A");
        conferenceRoom1.setCapacity(8);
        addConferenceRoom(conferenceRoom1);

        ConferenceRoom conferenceRoom2 = new ConferenceRoom();
        conferenceRoom2.setId(1);
        conferenceRoom2.setName("Room-B");
        conferenceRoom2.setCapacity(5);
        addConferenceRoom(conferenceRoom2);

        //add booking
        Booking booking1 = new Booking();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(LocalTime.parse("10:30:30"));
        timeSlot.setEndTime(LocalTime.parse("11:30:00"));
        booking1.setBookingId(1001);
        booking1.setUser(user1);
        booking1.setSlot(timeSlot);
        booking1.setBuilding(building1);
        booking1.setFloor(floor3);
        booking1.setConfRoom(conferenceRoom1);
        addBooking(booking1);

        //update booking with same user
        Booking booking2 = new Booking();
        TimeSlot timeSlot1 = new TimeSlot();
        timeSlot1.setStartTime(LocalTime.parse("12:30:30"));
        timeSlot1.setEndTime(LocalTime.parse("14:30:00"));
        booking2.setBookingId(1001);
        booking2.setUser(user1);
        booking2.setSlot(timeSlot1);
        booking2.setBuilding(building2);
        booking2.setFloor(floor4);
        booking2.setConfRoom(conferenceRoom2);
        try {
            bookingService.updateBooking(booking2);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }


    }

    private static void addUser(User user) throws UserNotFoundException {
        User createdUser = userService.createUser(user);
        System.out.println("User created successfully with user name: " + createdUser.getUserName());
    }

    private static void updateUser(User user) throws UserNotFoundException {
        User updatedUser = userService.updateUser(user);
        System.out.println("User updated successfully with user name: " + updatedUser.getUserName());
    }

    private static void addBuilding(Building building) {
        Building createdBuilding = buildingService.addBuilding(building);
        System.out.println("Building created successfully with building name: " + createdBuilding.getBuildingName());
    }

    private static void updateBuilding(Building building) {
        try {
            Building updatedBuilding = buildingService.updateBuilding(building);
            System.out.println("Building updated successfully with Building name: " + updatedBuilding.getBuildingName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addFloor(Floor floor) {
        Floor createdFloor = floorService.addFloor(floor);
        System.out.println("Floor Added successfully with Floor name: " + createdFloor.getFloorName()
        );
    }

    private static void getFloorsData() {
        List<Floor> floorList = floorRepository.getAllFloors();
        System.out.println("All the floors in each building : " + floorList.stream().map(Floor::getFloorName).toList());
    }

    private static void addConferenceRoom(ConferenceRoom conferenceRoom) {
        try {
            ConferenceRoom createdRoom = conferenceRoomService.addRoom(conferenceRoom);
            System.out.println("Conference Room added by room name: " + createdRoom.getName());
        } catch (NotFoundCID e) {
            System.out.println("Error :" + e.getMessage());
        }

    }

    private static void addBooking(Booking booking) {
        try {
            bookingService.createNewBooking(booking);
            System.out.println("Booking created successfully with booking id: " + booking.getBookingId());
        } catch (UserException | EntityNotFound e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}