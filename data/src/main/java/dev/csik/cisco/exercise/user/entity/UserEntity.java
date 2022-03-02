package dev.csik.cisco.exercise.user.entity;

import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user", schema = "cisco_exercise")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String password;
    private String email;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "preferred_phone_id")
    private PhoneEntity preferredPhone;
}
