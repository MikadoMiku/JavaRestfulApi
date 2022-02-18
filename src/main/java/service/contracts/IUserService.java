package service.contracts;

import models.AppUser;
import models.AppUserRole;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    AppUserRole saveRole(AppUserRole Role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
