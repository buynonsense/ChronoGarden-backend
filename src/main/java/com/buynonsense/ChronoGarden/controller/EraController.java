package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.model.Era;
import com.buynonsense.ChronoGarden.repository.EraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eras")
public class EraController {

    @Autowired
    private EraRepository eraRepository;

    @GetMapping
    public ResponseEntity<List<Era>> getAllEras() {
        List<Era> eras = eraRepository.findAllByOrderByDisplayOrderAsc();
        return ResponseEntity.ok(eras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Era> getEraById(@PathVariable Long id) {
        return eraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/period/{period}")
    public ResponseEntity<List<Era>> getErasByPeriod(@PathVariable String period) {
        List<Era> eras = eraRepository.findByPeriod(period);
        return ResponseEntity.ok(eras);
    }

    @PostMapping
    public ResponseEntity<Era> createEra(@RequestBody Era era) {
        Era savedEra = eraRepository.save(era);
        return ResponseEntity.ok(savedEra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Era> updateEra(@PathVariable Long id, @RequestBody Era eraDetails) {
        return eraRepository.findById(id)
                .map(era -> {
                    era.setName(eraDetails.getName());
                    era.setDescription(eraDetails.getDescription());
                    era.setDisplayOrder(eraDetails.getDisplayOrder());
                    era.setPeriod(eraDetails.getPeriod());
                    era.setClimate(eraDetails.getClimate());
                    era.setEnvironmentalFactors(eraDetails.getEnvironmentalFactors());

                    Era updatedEra = eraRepository.save(era);
                    return ResponseEntity.ok(updatedEra);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEra(@PathVariable Long id) {
        return eraRepository.findById(id)
                .map(era -> {
                    eraRepository.delete(era);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}