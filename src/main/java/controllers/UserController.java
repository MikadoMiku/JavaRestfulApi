package controllers;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import models.AppUser;
import models.AppUserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import publicApi.DTO.v1.RoleToUserForm;
import service.contracts.IUserService;
import services.UserService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final IUserService userService;

    @GetMapping("/user/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/getRole/{username}")
    public ResponseEntity<List<AppUserRole>> getUserRole(@PathVariable String username){
        return ResponseEntity.ok().body(userService.getUser(username).getRoles().stream().toList());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<AppUser> getUsers(@PathVariable String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("/user/create")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/create").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/create")
    public ResponseEntity<AppUserRole> saveRole(@RequestBody AppUserRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/create").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/user/addRole")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

