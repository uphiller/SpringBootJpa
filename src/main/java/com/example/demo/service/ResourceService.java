package com.example.demo.service;

import com.example.demo.entity.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getAllUser();
    List<Resource> getResources();
    void saveResource();
}
