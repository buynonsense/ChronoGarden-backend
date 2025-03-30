<<<<<<< HEAD
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByEra(String era);
=======
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
>>>>>>> d6310dba1852a4c6218eb5bb8b4334ffdb244361
}