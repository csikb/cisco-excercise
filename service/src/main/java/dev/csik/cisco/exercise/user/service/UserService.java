package dev.csik.cisco.exercise.user.service;

import dev.csik.cisco.exercise.user.model.CreateUser;
import dev.csik.cisco.exercise.user.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<User> getAllUsers();

    User addUser(CreateUser createUser);

    Optional<User> findUser(UUID userId);

    void removeUser(UUID userId);

    Optional<User> updatePreferredPhone(UUID userId, UUID phoneId);
}
