package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleRestController {
    @Autowired
    ResourceService resourceService;

    @GetMapping("/resources")
    public ResponseEntity<List<Resource>> home(Model model) {
        return ResponseEntity.ok(resourceService.getResources());
    }
}
