package dev.csik.cisco.exercise.user.service;

import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import dev.csik.cisco.exercise.phone.repository.PhoneRepository;
import dev.csik.cisco.exercise.user.entity.UserEntity;
import dev.csik.cisco.exercise.user.mapper.UserMapper;
import dev.csik.cisco.exercise.user.model.CreateUser;
import dev.csik.cisco.exercise.user.model.User;
import dev.csik.cisco.exercise.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository repository;
    private final PhoneRepository phoneRepository;
    private final UserMapper mapper;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll()
            .stream()
            .map(mapper::entityToModel)
            .collect(Collectors.toList());
    }

    @Override
    public User addUser(final CreateUser createUser) {
        final var entity = mapper.modelToEntity(createUser);
        final var savedEntity = repository.save(entity);
        return mapper.entityToModel(savedEntity);
    }

    @Override
    public Optional<User> findUser(final UUID userId) {
        return repository.findById(userId)
            .map(mapper::entityToModel);
    }

    @Override
    public void removeUser(final UUID userId) {
        repository.deleteById(userId);
    }

    @Override
    public Optional<User> updatePreferredPhone(final UUID userId, final UUID phoneId) {
        final var phone = phoneRepository.findById(phoneId)
            .orElseThrow(() -> new RuntimeException("Phone not found with phoneId: " + phoneId));

        if (!phone.getUserId().equals(userId)) {
            LOG.info("Can not assign phone to user. Phone belongs to other user.");
            throw new RuntimeException("Can not assign phone to user. Phone belongs to other user.");
        }

        return repository.findById(userId)
            .map((it) -> this.updatePreferredPhone(it, phone))
            .map(repository::save)
            .map(mapper::entityToModel);
    }

    private UserEntity updatePreferredPhone(final UserEntity user, final PhoneEntity phone) {
        user.setPreferredPhone(phone);
        return user;
    }
}
