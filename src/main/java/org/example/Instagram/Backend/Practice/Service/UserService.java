package org.example.Instagram.Backend.Practice.Service;

import org.example.Instagram.Backend.Practice.Model.Authentication;
import org.example.Instagram.Backend.Practice.Model.User;
import org.example.Instagram.Backend.Practice.Model.dto.SignInInput;
import org.example.Instagram.Backend.Practice.Model.dto.SignUpOutput;
import org.example.Instagram.Backend.Practice.Repository.IUserRepo;
import org.example.Instagram.Backend.Practice.Service.EncryptUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    public SignUpOutput userSignUp(User user) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //save the user with the new encrypted password

            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String userSignIn(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                Authentication authToken  = new Authentication(existingUser);
                authenticationService.saveAuthToken(authToken);

                //EmailHandler.sendEmail("mainakgh1@gmail.com","email testing",authToken.getTokenValue());
                return authToken.getToken() + " - This is your token for sign in";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public String userSignOut(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        Authentication token = authenticationService.findFirstByUser(user);
        authenticationService.removeToken(token);
        return "User Signed out successfully";
    }

    //This is for getting user by email
    public User findUserByEmail(String email) {
       return userRepo.findFirstByUserEmail(email);
    }

    //This is for updating phone number
    public String updateNumber(String phoneNumber, String email) {
        User user = userRepo.findFirstByUserEmail(email);

        user.setUserPhoneNumber(phoneNumber);
        userRepo.save(user);
        return "Phone Number Updated";
    }

    //This is for updating age
    public String updateAge(Integer age, String email) {
        User user = userRepo.findFirstByUserEmail(email);

        user.setUserAge(age);
        userRepo.save(user);
        return "Age Updated";
    }
}
