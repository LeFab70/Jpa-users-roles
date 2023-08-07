package day10.jpamappingassociations.services;

import day10.jpamappingassociations.entities.Role;
import day10.jpamappingassociations.entities.User;
import day10.jpamappingassociations.repositories.RoleRepository;
import day10.jpamappingassociations.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
   // @Autowired
    private UsersRepository usersRepository;
    //@Autowired     => use constructor for dependency of injection
    private RoleRepository roleRepository;

//    public UserServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository) {
//        this.usersRepository = usersRepository;
//        this.roleRepository = roleRepository;
//    }
    // user constructor with all parameters only

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        //usersRepository.save(user);
        return usersRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findByUserName(String userName) {

        return usersRepository.findByUserName(userName);


    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addUserToRole(String userName, String roleName) {
        User user=findByUserName(userName);
        Role role=findByRoleName(roleName);
       if (user.getRoles()!=null) {user.getRoles().add(role);role.getUsers().add(user);}
//        System.out.println(role);
//        System.out.println(user);

    }

    @Override
    public User authenticate(String userName, String password) {
        User user=usersRepository.findByUserName(userName);
        if(user==null) throw new RuntimeException("Bad Credentials");
        if(user!=null) {
            //System.out.println(user.getPassword());
            if(user.getPassword().equals(password)) return user;
        }
        throw new RuntimeException("Bad Credentials");
    }

}
