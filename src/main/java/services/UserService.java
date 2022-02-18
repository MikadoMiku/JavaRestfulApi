package services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.AppUser;
import models.AppUserRole;
import org.springframework.stereotype.Service;
import repo.contracts.IRoleRepo;
import repo.contracts.IUserRepo;
import service.contracts.IUserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService {
    private final IUserRepo userRepository;
    private final IRoleRepo roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user to the database");
        return userRepository.save(user);
    }

    @Override
    public AppUserRole saveRole(AppUserRole role) {
        log.info("Saving new role {} to the database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding new role {} to the user {}", roleName, username);
        AppUser user = userRepository.findByUsername(username);
        AppUserRole role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
