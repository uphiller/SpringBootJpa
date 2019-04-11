package com.example.demo;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

    @Autowired
    ResourceService resourceService;

    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void caseInSave() throws Exception{
        resourceService.saveResource();
        resourceService.rollbackResourceCheckedException();
        resourceService.rollbackResourceUncheckedException();
    }

    @Test
    public void findAll() throws Exception{
        List<Resource> result =  resourceService.getResources();
        assertEquals(3, result.size());
    }
}
