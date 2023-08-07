package day10.jpamappingassociations.repositories;

import day10.jpamappingassociations.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);

}
