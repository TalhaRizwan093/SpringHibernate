package com.toosterr.backend.controller;

import com.toosterr.backend.repository.AttributeRepository;
import com.toosterr.backend.service.AttributeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("/attributes")
    public ResponseEntity<?> getAllAttributes(){
        return new ResponseEntity<>(attributeService.findAll(), HttpStatus.OK);
    }

}
