package org.ConferenceBookingSystem.user.UserModel;

public class User {

    int id; //userId

    String userName;

    String password;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
