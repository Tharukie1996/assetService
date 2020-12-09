package com.project.eutech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.eutech.dto.StatisticDTO;
import com.project.eutech.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * This is the controller where you can find the end point used to retrieve necessary data for the dashboard
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Inject
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipment/stat")
    public ResponseEntity<StatisticDTO> populateDashboard() throws JsonProcessingException {
        return new ResponseEntity<>(equipmentService.getTableData(), HttpStatus.OK);
    }
}
