package day10.jpamappingassociations.web;

import day10.jpamappingassociations.entities.User;
import day10.jpamappingassociations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{userName}")
    public User user(@PathVariable String userName){
        User user=userService.findByUserName(userName);
        return user;
    }
}
