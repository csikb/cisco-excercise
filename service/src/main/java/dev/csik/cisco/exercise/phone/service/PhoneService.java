package dev.csik.cisco.exercise.phone.service;

import dev.csik.cisco.exercise.phone.model.CreatePhone;
import dev.csik.cisco.exercise.phone.model.Phone;
import java.util.List;
import java.util.UUID;

public interface PhoneService {

    Phone addPhone(final CreatePhone createPhone);

    List<Phone> findAllPhoneByUser(UUID userId);

    void removePhone(UUID phoneId);
}
