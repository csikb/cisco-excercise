package dev.csik.cisco.exercise.user.controller;

import dev.csik.cisco.exercise.user.model.CreateUser;
import dev.csik.cisco.exercise.user.model.User;
import dev.csik.cisco.exercise.user.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        final var users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody final CreateUser createUser) {
        final var createdUser = service.addUser(createUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser(@PathVariable("userId") final UUID userId) {
        final var user = service.findUser(userId);
        return ResponseEntity.of(user);
    }

    @PutMapping("/{userId}/preferred/{phoneId}")
    public ResponseEntity<User> updatePreferred(@PathVariable("userId") final UUID userId, @PathVariable("phoneId") final UUID phoneId) {
        final var user = service.updatePreferredPhone(userId, phoneId);
        return ResponseEntity.of(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable("userId") final UUID userId) {
        service.removeUser(userId);
        return ResponseEntity.ok().build();
    }
}
