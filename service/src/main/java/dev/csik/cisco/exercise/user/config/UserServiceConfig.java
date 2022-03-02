package dev.csik.cisco.exercise.user.config;

import dev.csik.cisco.exercise.phone.repository.PhoneRepository;
import dev.csik.cisco.exercise.user.mapper.UserMapper;
import dev.csik.cisco.exercise.user.repository.UserRepository;
import dev.csik.cisco.exercise.user.service.DefaultUserService;
import dev.csik.cisco.exercise.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

    private final UserRepository repository;
    private final PhoneRepository phoneRepository;

    public UserServiceConfig(final UserRepository userRepository, final PhoneRepository phoneRepository) {
        this.repository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Bean
    public UserService userService(final UserMapper userMapper) {
        return new DefaultUserService(repository, phoneRepository, userMapper);
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
