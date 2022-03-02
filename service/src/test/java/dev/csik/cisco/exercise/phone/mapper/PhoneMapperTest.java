package dev.csik.cisco.exercise.phone.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import dev.csik.cisco.exercise.phone.common.PhoneModel;
import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import dev.csik.cisco.exercise.phone.model.CreatePhone;
import dev.csik.cisco.exercise.phone.model.Phone;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneMapperTest {

    private static final UUID ID = UUID.fromString("01234567-0123-0123-0123-0123456789ab");
    private static final PhoneModel PHONE_MODEL = PhoneModel.IPHONE;
    private static final String NAME = "Iphone 11";
    private static final String PHONE_NUMBER = "+36 20 1234-567";
    private static final UUID USER_ID = UUID.fromString("76543210-0123-0123-0123-0123456789ab");
    private static final CreatePhone CREATE_PHONE = new CreatePhone(NAME, PHONE_MODEL, PHONE_NUMBER, USER_ID);
    private static final Phone PHONE = new Phone(ID, NAME, PHONE_MODEL, PHONE_NUMBER);
    private static final PhoneEntity PHONE_ENTITY = createEntity();

    private PhoneMapper underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new PhoneMapper();
        this.underTest.setUuidGenerator(() -> ID);
    }

    @Test
    void shouldMapModelToEntity() {
        final var result = underTest.modelToEntity(CREATE_PHONE);

        assertThat(result).isEqualTo(PHONE_ENTITY);
    }

    @Test
    void shouldMapEntityToModel() {
        final var phone = underTest.entityToModel(PHONE_ENTITY);

        assertThat(phone).isEqualTo(PHONE);
    }

    private static PhoneEntity createEntity() {
        final var entity = new PhoneEntity();
        entity.setId(ID);
        entity.setModel(PHONE_MODEL);
        entity.setName(NAME);
        entity.setUserId(USER_ID);
        entity.setPhoneNumber(PHONE_NUMBER);
        return entity;
    }
}
