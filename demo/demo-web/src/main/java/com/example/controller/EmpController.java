package com.example.controller;

import com.example.pojo.GymEmp;
import com.example.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Reference
    private EmpService empService;

    @RequestMapping("/selectByMajor")
    @ResponseBody
    public List<GymEmp> findByMajor(String major) {
        return empService.findByMajor(major);
    }
}
