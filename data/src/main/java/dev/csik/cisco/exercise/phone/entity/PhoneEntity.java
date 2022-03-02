package dev.csik.cisco.exercise.phone.entity;

import dev.csik.cisco.exercise.phone.common.PhoneModel;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "phone", schema = "cisco_exercise")
public class PhoneEntity {
    @Id
    private UUID id;
    private String name;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private PhoneModel model;
    private UUID userId;
}
