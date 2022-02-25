package controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publicApi.DTO.v1.LoginData;
import publicApi.DTO.v1.RegisterData;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/register")
    public void register(@RequestBody RegisterData registerData){

    }

    @PostMapping("/login")
    public void login(@RequestBody LoginData loginData){

    }
}
