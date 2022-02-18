package util;

import lombok.RequiredArgsConstructor;
import models.AppUser;
import models.AppUserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import service.contracts.IUserService;
import services.UserService;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class PostApplicationRunner {

    private final IUserService userService;

    @EventListener(ContextRefreshedEvent.class)
    public void applicationEvent(ContextRefreshedEvent event) {
        System.out.println(event.getApplicationContext().getDisplayName());

        if (event.getApplicationContext().getDisplayName().equals("WebApplicationContext for namespace 'dispatcher-servlet'")) {
            AppUser user1 = new AppUser(null, "Bobby Pin", "Bobster", "1234", new ArrayList<>());
            AppUser user2 = new AppUser(null, "Laura Krepple", "LKrep", "1234", new ArrayList<>());
            AppUser user3 = new AppUser(null, "Steven Roger", "stroger", "1234", new ArrayList<>());
            AppUser user4 = new AppUser(null, "Kevin Bacon", "Baconester", "qwerty", new ArrayList<>());

            AppUserRole role1 = new AppUserRole(null, "ROLE_USER");
            AppUserRole role2 = new AppUserRole(null, "ROLE_ADMIN");


            userService.saveUser(user1);
            userService.saveUser(user2);
            userService.saveUser(user3);
            userService.saveUser(user4);

            userService.saveRole(role1);
            userService.saveRole(role2);

            userService.addRoleToUser("Bobster", "ROLE_USER");
            userService.addRoleToUser("LKrep", "ROLE_ADMIN");
            userService.addRoleToUser("stroger", "ROLE_USER");
            userService.addRoleToUser("Baconester", "ROLE_USER");
        }


    }
}
