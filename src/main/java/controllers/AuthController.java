package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publicApi.DTO.v1.RegisterData;

@RestController
@RequestMapping("/auth")
public class AuthController {


    public void signUp(@RequestBody RegisterData RegisterData){

    }
}
