package by.tms.service;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static List<User> users = new ArrayList<>();

    public void saveUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }

    public User getByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
