package com.example.demo.service;

import com.example.demo.entity.Resource;

import java.util.List;

public interface ResourceService {
    void saveResource();
    void rollbackResourceCheckedException() throws Exception;
    void rollbackResourceUncheckedException();
    List<Resource> getResources();
}
