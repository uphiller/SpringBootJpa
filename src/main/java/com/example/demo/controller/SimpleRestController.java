package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SimpleRestController {
    @Autowired
    ResourceService resourceService;

    @GetMapping("/resources")
    public ResponseEntity<List<Resource>> home(Model model) {
        List list = new ArrayList();
        Map data = new HashMap();
        data.put("sTitle","곡성");
        data.put("sDate","20160512");
        data.put("sShare",32);
        data.put("sCount",101827);
        data.put("sNation","한국");
        data.put("sDist","이십세기폭스코리아(주)");
        list.add(data);

        return ResponseEntity.ok(list);
    }

    @PostMapping("/movie")
    public ResponseEntity<String> movie(Object model) {
        System.out.println(model);
        return ResponseEntity.ok("ok");
    }
}
