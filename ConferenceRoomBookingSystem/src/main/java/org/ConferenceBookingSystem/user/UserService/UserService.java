package org.ConferenceBookingSystem.user.UserService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.UserNotFoundException;
import org.ConferenceBookingSystem.user.UserModel.User;

public interface UserService {

    public User createUser(User user) throws UserNotFoundException;

    public User updateUser(User user) throws UserNotFoundException;

    public String deleteuser(int id);
}
