package com.example.service.impl;

import com.example.mapper.CardClassMapper;
import com.example.mapper.GymClassMapper;
import com.example.pojo.CardClass;
import com.example.pojo.GymClass;
import com.example.pojo.GymClassExample;
import com.example.service.ClassService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private GymClassMapper gymClassMapper;
    @Autowired
    private CardClassMapper cardClassMapper;

    @Override
    public List<GymClass> findByName(String className) {
        GymClassExample example = new GymClassExample();
        example.createCriteria().andGymClassNameLike("%"+className+"%");
        example.setOrderByClause("beginTime DESC");
        return gymClassMapper.selectByExample(example);
    }

    @Override
    public int updateCardClass(String card_id, long class_id) {
        CardClass cc = new CardClass();
        cc.setClassId(class_id);
        cc.setCardId(card_id);
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        cc.setBegintime(date);
        calendar.add(Calendar.YEAR,1); // 把日期往后增加一年
        date=calendar.getTime(); // 这个时间就是日期往后推一天的结果
        cc.setEndtime(date);
        try {
            cardClassMapper.insert(cc);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

}
