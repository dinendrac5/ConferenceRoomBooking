package org.ConferenceBookingSystem.user.UserService;

public interface UserService {

    void createUser(String userName, String password);

    void updateUser(String userName, String password);

    void deleteuser(int id);
}
