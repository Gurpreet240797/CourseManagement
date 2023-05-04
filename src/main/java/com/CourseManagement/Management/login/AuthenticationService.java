package com.CourseManagement.Management.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("Gurpreet Singh");
        boolean isValidPassword = password.equalsIgnoreCase("gp");

        return isValidUserName && isValidPassword;
    }
}
