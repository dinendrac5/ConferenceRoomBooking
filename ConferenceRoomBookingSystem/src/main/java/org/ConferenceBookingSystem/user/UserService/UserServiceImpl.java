package org.ConferenceBookingSystem.user.UserService;

import org.ConferenceBookingSystem.Exceptions.UserExceptions.UserNotFoundException;
import org.ConferenceBookingSystem.user.UserModel.User;
import org.ConferenceBookingSystem.user.UserRepository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) throws UserNotFoundException {
        User savedUser = userRepository.findById(user.getId());
        if (savedUser == null) {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setUserName(user.getUserName());
            newUser.setPassword(user.getPassword());
            userRepository.addUser(newUser);
            return newUser;
        } else {
            throw new UserNotFoundException("User already exists");
        }
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User savedUser = userRepository.findById(user.getId());
        if (savedUser != null && savedUser.getId() == user.getId()) {
            savedUser.setId(user.getId());
            savedUser.setUserName(user.getUserName());
            savedUser.setPassword(user.getPassword());
            userRepository.updateUser(savedUser);
            return savedUser;
        }
        throw new UserNotFoundException("User does not exists with username: " + user.getUserName());
    }

    @Override
    public String deleteuser(int id) {
        User savedUser = userRepository.findById(id);
        if (savedUser != null) {
            userRepository.removeUser(savedUser);
            return "Deleted User By User Name " + savedUser.getUserName();
        }
        return "";
    }
}
