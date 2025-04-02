package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.CareRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CareRecordRepository extends JpaRepository<CareRecord, Long> {
    List<CareRecord> findByUserId(Long userId);

    List<CareRecord> findByPlantId(Long plantId);

    List<CareRecord> findByUserIdAndPlantId(Long userId, Long plantId);

    List<CareRecord> findByPlantIdOrderByTimestampDesc(Long plantId, Pageable pageable);
}
