package by.tms.service;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private List<User> users = new ArrayList<>();

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
