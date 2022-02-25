package repo.contracts;

import models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import publicApi.DTO.v1.LoginData;


//How do i make a custom repository without implementing everything in JpaRepository?
//Do i make a fully custom repository for login and register purposes? or use UserRepository to add users instead
public interface IAuthRepo extends JpaRepository<AppUser, Long> {
    AppUser login(LoginData loginData);
}
