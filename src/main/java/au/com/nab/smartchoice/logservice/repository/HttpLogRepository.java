package au.com.nab.smartchoice.logservice.repository;

import au.com.nab.smartchoice.logservice.dto.entity.HttpLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HttpLogRepository extends JpaRepository<HttpLogEntity, UUID> {
    Optional<HttpLogEntity> findByLogId(String logId);

    boolean existsByLogId(String logId);
}
