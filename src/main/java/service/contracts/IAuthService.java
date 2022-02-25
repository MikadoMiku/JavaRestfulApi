package service.contracts;

import publicApi.DTO.v1.LoginData;
import publicApi.DTO.v1.RegisterData;

public interface IAuthService {
    String login(LoginData loginData);
    String register(RegisterData registerData);
}
