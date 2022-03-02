package dev.csik.cisco.exercise.user.model;

import java.util.UUID;
import lombok.Value;

@Value
public class User {
    UUID userId;
    String userName;
    String password;
    String emailAddress;
    String preferredPhoneNumber;
}
