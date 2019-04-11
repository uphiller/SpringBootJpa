package com.example.demo;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RepositoryTests {
    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void deleteByName() {
        Resource param = new Resource();
        param.setName("java");
        boolean result = resourceRepository.deleteByName(param);
        assertEquals(true, result);
    }
}
