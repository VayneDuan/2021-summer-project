package com.example.service.impl;

import com.example.mapper.GymEmpMapper;
import com.example.pojo.GymEmp;
import com.example.pojo.GymEmpExample;
import com.example.service.EmpService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version ="1.0.0")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private GymEmpMapper gymEmpMapper;

    @Override
    public List<GymEmp> findByMajor(String major) {
        GymEmpExample example = new GymEmpExample();
        // 模糊查询
        example.createCriteria().andMajorLike("%"+major+"%");
        return gymEmpMapper.selectByExample(example);
    }

    @Override
    public List<GymEmp> findByName(String name) {
        GymEmpExample example = new GymEmpExample();
        // 模糊查询
        example.createCriteria().andGymEmpNameLike("%"+name+"%");
        return gymEmpMapper.selectByExample(example);
    }
}
