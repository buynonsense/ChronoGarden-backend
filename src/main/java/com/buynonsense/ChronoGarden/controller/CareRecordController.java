package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.model.CareRecord;
import com.buynonsense.ChronoGarden.model.Plant;
import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.CareRecordRepository;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/carerecords")
public class CareRecordController {

    @Autowired
    private CareRecordRepository careRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlantRepository plantRepository;

    // 获取当前用户的所有养护记录
    @GetMapping
    public ResponseEntity<List<CareRecord>> getCurrentUserCareRecords() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<CareRecord> records = careRecordRepository.findByUserId(user.getId());
        return ResponseEntity.ok(records);
    }

    // 获取特定植物的养护记录
    @GetMapping("/plant/{plantId}")
    public ResponseEntity<List<CareRecord>> getPlantCareRecords(@PathVariable Long plantId) {
        if (!plantRepository.existsById(plantId)) {
            return ResponseEntity.notFound().build();
        }

        List<CareRecord> records = careRecordRepository.findByPlantId(plantId);
        return ResponseEntity.ok(records);
    }

    // 获取当前用户对特定植物的养护记录
    @GetMapping("/plant/{plantId}/user")
    public ResponseEntity<List<CareRecord>> getUserPlantCareRecords(@PathVariable Long plantId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user == null || !plantRepository.existsById(plantId)) {
            return ResponseEntity.notFound().build();
        }

        List<CareRecord> records = careRecordRepository.findByUserIdAndPlantId(user.getId(), plantId);
        return ResponseEntity.ok(records);
    }

    // 添加养护记录
    @PostMapping
    public ResponseEntity<CareRecord> addCareRecord(@RequestBody CareRecord careRecord) {
        // 获取当前用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        // 验证植物存在
        if (careRecord.getPlant() != null && careRecord.getPlant().getId() != null) {
            return plantRepository.findById(careRecord.getPlant().getId())
                    .map(plant -> {
                        careRecord.setUser(user);
                        careRecord.setPlant(plant);
                        careRecord.setTimestamp(LocalDateTime.now());

                        CareRecord savedRecord = careRecordRepository.save(careRecord);
                        return ResponseEntity.ok(savedRecord);
                    })
                    .orElse(ResponseEntity.badRequest().build());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareRecord> updateCareRecord(@PathVariable Long id,
                                                       @RequestBody CareRecord careRecordDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return careRecordRepository.findById(id)
                .<ResponseEntity<CareRecord>>map(careRecord -> {
                    if (!careRecord.getUser().getId().equals(user.getId())) {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).<CareRecord>build();
                    }

                    if (careRecordDetails.getActionType() != null) {
                        careRecord.setActionType(careRecordDetails.getActionType());
                    }
                    if (careRecordDetails.getNotes() != null) {
                        careRecord.setNotes(careRecordDetails.getNotes());
                    }
                    if (careRecordDetails.getTimestamp() != null) {
                        careRecord.setTimestamp(careRecordDetails.getTimestamp());
                    }

                    CareRecord updatedRecord = careRecordRepository.save(careRecord);
                    return ResponseEntity.ok(updatedRecord);
                })
                .orElseGet(() -> ResponseEntity.notFound().<CareRecord>build());
    }

    // 删除养护记录
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareRecord(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        return careRecordRepository.findById(id)
                .map(careRecord -> {
                    // 验证是当前用户的记录
                    if (!careRecord.getUser().getId().equals(user.getId())) {
                        return ResponseEntity.status(403).<Void>build();
                    }

                    careRecordRepository.delete(careRecord);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}