package dev.csik.cisco.exercise.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import dev.csik.cisco.exercise.phone.repository.PhoneRepository;
import dev.csik.cisco.exercise.user.entity.UserEntity;
import dev.csik.cisco.exercise.user.mapper.UserMapper;
import dev.csik.cisco.exercise.user.model.User;
import dev.csik.cisco.exercise.user.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DefaultUserServiceTest {
    private static final UUID USER_ID = UUID.fromString("01234567-0123-0123-0123-0123456789ab");
    private static final UUID OTHER_USER_ID = UUID.fromString("01234567-0123-0123-0123-0123456789ab");
    private static final UUID PHONE_ID = UUID.fromString("01234567-0123-0123-0123-0123456789ab");
    private static final PhoneEntity PHONE_ENTITY = createPhoneEntity(USER_ID);
    private static final PhoneEntity OTHER_USER_PHONE_ENTITY = createPhoneEntity(OTHER_USER_ID);
    private static final UserEntity USER_ENTITY = new UserEntity();
    private static final User USER = new User(USER_ID, "", "", "", "");

    private static PhoneEntity createPhoneEntity(final UUID userId) {
        final var entity = new PhoneEntity();
        entity.setUserId(userId);
        return entity;
    }

    @Mock
    private UserRepository mockRepository;
    @Mock
    private PhoneRepository mockPhoneRepository;
    @Mock
    private UserMapper mockMapper;

    private DefaultUserService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.underTest = new DefaultUserService(mockRepository, mockPhoneRepository, mockMapper);
    }

    @Test
    void shouldThrowWhenPhoneDoesNotExist() {
        given(mockPhoneRepository.findById(PHONE_ID)).willReturn(Optional.empty());

        final Executable result = () -> underTest.updatePreferredPhone(USER_ID, PHONE_ID);

        assertThrows(RuntimeException.class, result);
    }

    @Test
    void shouldThrowWhenFoundPhoneBelongsToOtherUser() {
        given(mockPhoneRepository.findById(PHONE_ID)).willReturn(Optional.of(OTHER_USER_PHONE_ENTITY));

        final Executable result = () -> underTest.updatePreferredPhone(USER_ID, PHONE_ID);

        assertThrows(RuntimeException.class, result);
    }

    @Test
    void shouldReturnEmptyWhenUserWasNotFound() {
        given(mockPhoneRepository.findById(PHONE_ID)).willReturn(Optional.of(PHONE_ENTITY));
        given(mockRepository.findById(USER_ID)).willReturn(Optional.empty());

        final var result =  underTest.updatePreferredPhone(USER_ID, PHONE_ID);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnUpdatedUserWhenPreferredPhoneNumberWasUpdated() {
        given(mockPhoneRepository.findById(PHONE_ID)).willReturn(Optional.of(PHONE_ENTITY));
        given(mockRepository.findById(USER_ID)).willReturn(Optional.of(USER_ENTITY));
        final var updatedUserEntity = USER_ENTITY;
        updatedUserEntity.setPreferredPhone(PHONE_ENTITY);
        given(mockRepository.save(USER_ENTITY)).willReturn(updatedUserEntity);
        given(mockMapper.entityToModel(USER_ENTITY)).willReturn(USER);

        final var result =  underTest.updatePreferredPhone(USER_ID, PHONE_ID);

        assertThat(result).hasValue(USER);
    }
}
