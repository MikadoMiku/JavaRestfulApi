package services;

import org.springframework.stereotype.Service;
import publicApi.DTO.v1.LoginData;
import publicApi.DTO.v1.RegisterData;
import service.contracts.IAuthService;

@Service
public class AuthService implements IAuthService {

    @Override
    public String login(LoginData loginData) {
        return null;
    }

    @Override
    public String register(RegisterData registerData) {
        return null;
    }
}
