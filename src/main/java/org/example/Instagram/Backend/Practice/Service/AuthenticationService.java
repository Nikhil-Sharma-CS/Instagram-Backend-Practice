package org.example.Instagram.Backend.Practice.Service;

import org.example.Instagram.Backend.Practice.Model.Authentication;
import org.example.Instagram.Backend.Practice.Model.User;
import org.example.Instagram.Backend.Practice.Repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public boolean authenticate(String email, String token) {

        Authentication AuthToken =authenticationRepo.findFirstByToken(token);

        if(AuthToken == null)
        {
            return  false;
        }

        //Now we will check is email provided is equal to email attached to token or not
        String tokenEmail = AuthToken.getUser().getUserEmail();

        return tokenEmail.equals(email);
    }

    public void saveAuthToken(Authentication Token) {

        authenticationRepo.save(Token);
    }

    public Authentication findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(Authentication token) {
        authenticationRepo.delete(token);
    }
}
