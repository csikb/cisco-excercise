package dev.csik.cisco.exercise.phone.mapper;

import dev.csik.cisco.exercise.common.EntityModelMapper;
import dev.csik.cisco.exercise.common.ModelEntityMapper;
import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import dev.csik.cisco.exercise.phone.model.CreatePhone;
import dev.csik.cisco.exercise.phone.model.Phone;
import java.util.UUID;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.Setter;

public class PhoneMapper implements EntityModelMapper<PhoneEntity, Phone>, ModelEntityMapper<CreatePhone, PhoneEntity> {

    @Setter(AccessLevel.PACKAGE)
    private Supplier<UUID> uuidGenerator = UUID::randomUUID;

    @Override
    public PhoneEntity modelToEntity(final CreatePhone model) {
        final var entity = new PhoneEntity();
        entity.setId(uuidGenerator.get());
        entity.setName(model.getPhoneName());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setModel(model.getPhoneModel());
        entity.setUserId(model.getUserId());
        return entity;
    }

    @Override
    public Phone entityToModel(final PhoneEntity entity) {
        return new Phone(
            entity.getId(),
            entity.getName(),
            entity.getModel(),
            entity.getPhoneNumber()
        );
    }
}
