package dev.csik.cisco.exercise.phone.repository;

import dev.csik.cisco.exercise.phone.entity.PhoneEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, UUID> {

    @Query(value = "SELECT phone FROM PhoneEntity phone WHERE phone.userId = :userId")
    List<PhoneEntity> findAllByUserId(@Param("userId") UUID userId);
}
