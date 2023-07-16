package org.example.Instagram.Backend.Practice.Controller;

import jakarta.validation.Valid;
import org.example.Instagram.Backend.Practice.Model.User;
import org.example.Instagram.Backend.Practice.Model.dto.SignInInput;
import org.example.Instagram.Backend.Practice.Model.dto.SignUpOutput;
import org.example.Instagram.Backend.Practice.Service.AuthenticationService;
import org.example.Instagram.Backend.Practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    //Firstly we will sign up user
    @PostMapping("userSignUp")
    SignUpOutput userSignUp(@RequestBody User user)
    {
        return userService.userSignUp(user);
    }


    //Now we will sign in user
    @PostMapping("userSignIn")
    String userSignIn(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.userSignIn(signInInput);
    }


    //Now we will sign out user
    @DeleteMapping("userSignOut")
    String userSignOut(String email, String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return userService.userSignOut(email);
        }
        return "Sign out not allowed for non authenticated user";
    }


    //Update user phoneNumber
    @PutMapping("user/updatePhoneNumber")
    String userUpdateNumber(String phoneNumber, String email, String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return userService.updateNumber(phoneNumber, email);
        }
        return "Update not allowed for non authenticated user";
    }

    //Update user age
    @PutMapping("user/updateAge")
    String userUpdateAge(Integer Age,String email, String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return userService.updateAge(Age, email);
        }
        return "Update not allowed for non authenticated user";
    }
}
