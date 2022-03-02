package dev.csik.cisco.exercise.user.repository;

import dev.csik.cisco.exercise.user.entity.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    @Override
    List<UserEntity> findAll();
}
