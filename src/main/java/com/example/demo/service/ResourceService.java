package com.example.demo.service;

public interface ResourceService {
    void saveResource();
    void rollbackResourceCheckedException() throws Exception;
    void rollbackResourceUncheckedException();
}
