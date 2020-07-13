package by.company.controllers;

import by.company.entities.User;
import by.company.service.UserResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private List<User> userList;

    @Autowired
    private UserResources userResources;

    @PostMapping(path = "/reg")
    public ResponseEntity<String> reg(@RequestBody User user){
        userResources.save(user);
        return new ResponseEntity<>("Reg!", HttpStatus.OK);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@RequestBody User user, HttpSession httpSession){
        User byLogin = userResources.getByLogin(user.getLogin());
        if (byLogin.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("myUser", byLogin);
            userList.add(byLogin);
            return new ResponseEntity<>("Auth!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error.Please,try again!", HttpStatus.BAD_REQUEST);
    }
}
