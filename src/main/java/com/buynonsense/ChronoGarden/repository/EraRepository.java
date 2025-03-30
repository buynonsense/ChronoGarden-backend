package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.Era;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EraRepository extends JpaRepository<Era, Long> {
    List<Era> findAllByOrderByDisplayOrderAsc();

    // 添加按时期查询的方法（与旧的TimeNode兼容）
    List<Era> findByPeriod(String period);
}