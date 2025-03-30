<<<<<<< HEAD
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.CareRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareRecordRepository extends JpaRepository<CareRecord, Long> {
    List<CareRecord> findByUserId(Long userId);

    List<CareRecord> findByPlantId(Long plantId);

    List<CareRecord> findByUserIdAndPlantId(Long userId, Long plantId);
}
=======
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.CareRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareRecordRepository extends JpaRepository<CareRecord, Long> {
}
>>>>>>> d6310dba1852a4c6218eb5bb8b4334ffdb244361
