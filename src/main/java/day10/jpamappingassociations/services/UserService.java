package day10.jpamappingassociations.services;

import day10.jpamappingassociations.entities.Role;
import day10.jpamappingassociations.entities.User;

public interface UserService  {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findByUserName(String userName);
    Role findByRoleName(String roleName);
    void addUserToRole(String userName,String roleName);
    User authenticate(String userName,String password);

}
