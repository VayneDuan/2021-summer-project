package com.example.controller;

import com.example.pojo.GymEmp;
import com.example.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Reference(version = "1.0.0", url = "dubbo://localhost:20888?version=1.0.0")
    private EmpService empService;

    @RequestMapping("/selectByMajor")
    @ResponseBody
    public Map<String, Object> findByMajor(String major) {
        Map<String, Object> data = new HashMap<>();
        data.put("emp_list", empService.findByMajor(major));
        return data;
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Map<String, Object> findByName(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put("emp_list", empService.findByName(name));
        return data;
    }
}
