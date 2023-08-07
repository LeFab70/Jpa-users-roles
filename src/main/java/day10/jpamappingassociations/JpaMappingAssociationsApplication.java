package day10.jpamappingassociations;

import day10.jpamappingassociations.entities.Role;
import day10.jpamappingassociations.entities.User;
import day10.jpamappingassociations.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaMappingAssociationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaMappingAssociationsApplication.class, args);
	}


	// testing code
	@Bean //execution au demarrage
	CommandLineRunner start(UserService userService){
		return args -> {
			User user1=new User();
			user1.setUserName("fab01");
			user1.setLogin("fab");
			user1.setPassword("1234");
			userService.addNewUser(user1);

			User user2=new User();
			user2.setUserName("fab");
			user2.setLogin("fab01");
			user2.setPassword("1234");
			userService.addNewUser(user2);

			Stream.of("ADMIN","USER","STUDENT").forEach(roleName->{
				Role role=new Role();
				role.setRoleName(roleName);
				userService.addNewRole(role);
			});

            userService.addUserToRole("fab","ADMIN");
			userService.addUserToRole("fab","USER");
			userService.addUserToRole("fab01","STUDENT");
			userService.addUserToRole("fab01","ADMIN");
			try{
		  		User user =userService.authenticate("fab","1234");
				System.out.println(user.getLogin());
				System.out.println(user.getUserName());
				System.out.println("Roles=>");
				user.getRoles().forEach(roleUser->{
					System.out.println(roleUser.toString());
				});
				;}
			catch (Exception exception){
 				exception.printStackTrace();
				 //exception.getCause().printStackTrace();
			}
//			Role role2=new Role();
//			role2.setGroupName("user");
//			userService.addNewRole(role2);

		};
	}
}
