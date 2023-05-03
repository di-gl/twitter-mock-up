package com.example.twittermockup.util;

import com.example.twittermockup.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserUtil {

    public void patchUser(User user, Map<String, String> partialUser) {
        String firstName = partialUser.get("firstName");
        String lastName = partialUser.get("lastName");
        String email = partialUser.get("email");
        String password = partialUser.get("password");

        if (firstName != null) {
            user.setFirstName(firstName);
        }

        if (lastName != null) {
            user.setLastName(lastName);
        }

        if (email != null) {
            user.setEmail(email);
        }

        if (password != null) {
            user.setPassword(password);
        }
    }
}
