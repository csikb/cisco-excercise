package dev.csik.cisco.exercise.phone.service;

import dev.csik.cisco.exercise.phone.mapper.PhoneMapper;
import dev.csik.cisco.exercise.phone.model.CreatePhone;
import dev.csik.cisco.exercise.phone.model.Phone;
import dev.csik.cisco.exercise.phone.repository.PhoneRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultPhoneService implements PhoneService {

    private final PhoneRepository repository;
    private final PhoneMapper mapper;

    @Override
    public Phone addPhone(final CreatePhone createPhone) {
        final var phoneEntity = mapper.modelToEntity(createPhone);
        final var savedPhone = repository.save(phoneEntity);
        return mapper.entityToModel(savedPhone);
    }

    @Override
    public List<Phone> findAllPhoneByUser(final UUID userId) {
        return repository.findAllByUserId(userId)
            .stream()
            .map(mapper::entityToModel)
            .collect(Collectors.toList());
    }

    @Override
    public void removePhone(final UUID phoneId) {
        repository.deleteById(phoneId);
    }
}
