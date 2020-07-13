package by.company.service;

import by.company.entities.User;
import by.company.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResources {
    @Autowired
    List<User> userList;

    public void save(User user){
        userList.add(user);
    }

    public User getByLogin(String login){
        for (User user: userList) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        throw new NotFoundException("ERROR!!!USER NOT FOUND");
    }
}
