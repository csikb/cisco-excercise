package dev.csik.cisco.exercise.user.mapper;

import dev.csik.cisco.exercise.common.EntityModelMapper;
import dev.csik.cisco.exercise.common.ModelEntityMapper;
import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import dev.csik.cisco.exercise.user.entity.UserEntity;
import dev.csik.cisco.exercise.user.model.CreateUser;
import dev.csik.cisco.exercise.user.model.User;
import java.util.Optional;
import java.util.UUID;

public class UserMapper implements ModelEntityMapper<CreateUser, UserEntity>, EntityModelMapper<UserEntity, User> {


    @Override
    public UserEntity modelToEntity(final CreateUser model) {
        final var entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setName(model.getUserName());
        entity.setPassword(model.getPassword());
        entity.setEmail(model.getEmailAddress());
        entity.setPreferredPhone(null);
        return entity;
    }

    @Override
    public User entityToModel(final UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getName(),
            entity.getPassword(),
            entity.getEmail(),
            Optional.ofNullable(entity.getPreferredPhone())
                .map(PhoneEntity::getPhoneNumber)
                .orElse("")
        );
    }
}
