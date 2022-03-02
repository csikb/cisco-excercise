package dev.csik.cisco.exercise.phone.model;

import dev.csik.cisco.exercise.phone.common.PhoneModel;
import java.util.UUID;
import lombok.Value;

@Value
public class CreatePhone {
    String phoneName;
    PhoneModel phoneModel;
    String phoneNumber;
    UUID userId;
}
