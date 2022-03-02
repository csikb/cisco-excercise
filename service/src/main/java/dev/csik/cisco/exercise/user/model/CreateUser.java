package dev.csik.cisco.exercise.user.model;

import lombok.Value;

@Value
public class CreateUser {
    String userName;
    String password;
    String emailAddress;
}
