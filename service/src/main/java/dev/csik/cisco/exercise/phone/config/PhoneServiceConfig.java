package dev.csik.cisco.exercise.phone.config;

import dev.csik.cisco.exercise.phone.mapper.PhoneMapper;
import dev.csik.cisco.exercise.phone.repository.PhoneRepository;
import dev.csik.cisco.exercise.phone.service.DefaultPhoneService;
import dev.csik.cisco.exercise.phone.service.PhoneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneServiceConfig {

    private final PhoneRepository repository;

    public PhoneServiceConfig(final PhoneRepository phoneRepository) {
        this.repository = phoneRepository;
    }

    @Bean
    public PhoneService phoneService(final PhoneMapper phoneMapper) {
        return new DefaultPhoneService(repository, phoneMapper);
    }

    @Bean
    public PhoneMapper phoneMapper() {
        return new PhoneMapper();
    }
}
