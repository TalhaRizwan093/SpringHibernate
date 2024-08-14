package com.toosterr.backend.service;

import com.toosterr.backend.entity.Attribute;
import com.toosterr.backend.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }
}
