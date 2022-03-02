package dev.csik.cisco.exercise.phone.controller;

import dev.csik.cisco.exercise.phone.model.CreatePhone;
import dev.csik.cisco.exercise.phone.model.Phone;
import dev.csik.cisco.exercise.phone.service.PhoneService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phone")
@RequiredArgsConstructor
public class PhoneController {

    @Autowired
    private final PhoneService service;

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhonesByUser(@RequestParam("userId") final UUID userId) {
        final var allPhoneByUser = service.findAllPhoneByUser(userId);
        return ResponseEntity.ok(allPhoneByUser);
    }

    @PostMapping
    public ResponseEntity<Phone> addPhone(@RequestBody final CreatePhone createPhone) {
        final var phone = service.addPhone(createPhone);
        return ResponseEntity.ok(phone);
    }

    @DeleteMapping("/{phoneId}")
    public ResponseEntity<?> removePhone(@PathVariable final UUID phoneId) {
        service.removePhone(phoneId);
        return ResponseEntity.ok().build();
    }
}
