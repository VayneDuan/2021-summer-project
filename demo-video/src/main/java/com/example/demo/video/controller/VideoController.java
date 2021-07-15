package com.example.demo.video.controller;

import com.example.demo.video.service.VideoService;
import com.example.demo.pojo.Card;
import com.example.demo.pojo.MemberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class VideoController {
    @Autowired
    VideoService VideoService;

    //TODO
    //* 实现思路:
        //* 1. 前端传入member_id, video_id
        //* 2. 通过member_id, 查DB拿到card_id (member_id可能不合法,报错 / 没开VIP的话, card_id可能不存在,返回提示开通VIP )
        //* 3. 通过card_id, 查DB拿到video_id_list, 遍历list, 看是否有和传入的video_id相同的id
        //*     3.1 如果存在, 通过这个video_id 查DB拿到url & name 等信息, 返回给前端
        //*     3.2 如果不存在, 返回: 权限不够, 请买课/买VIP

    //! 以下是旧代码, 不管
    // @RequestMapping("/buyVipSuccess")
    // public String buyVipSuccess(Model model, String member_id,Integer if_times,Integer card_level,Double amount) { //! 传入 member_id & Card 相关信息
    //     //! Card -> gym_card

    //     //! 生成card_id

    //     //! 生成当前时间
    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     Date beginDate = new Date();
    //     Calendar calendar = new GregorianCalendar();
    //     calendar.setTime(beginDate);
    //     beginDate = calendar.getTime();

    //     //! 生成endTime
    //     Date endDate = new Date();
    //     Calendar calendar1 = new GregorianCalendar();
    //     calendar1.setTime(beginDate);


    //     //! level 1,2,3     if_times 0,1
    //     if(amount<0 || card_level<1 || card_level>3 || (if_times!=1 && if_times!=0)){
    //         //! 参数错误
    //         System.out.println("[ERROR] arg wrong");
    //         model.addAttribute("data","参数错误");
    //         return "login"; //TODO 应该返回到 错误提示(重试)页面, 这种参数错误一般不会发生, 因为是前端生成的
    //     }


    //     //! 根据 if_times 判断是不是次卡, 设置amount, 生成endTime
    //     //! 在video 服务, 根据if_times 来判断 校验对象是 endTime or amount
    //     if(if_times==1){
    //         //! 是次卡的话, endTime 是100年后
    //         calendar1.add(Calendar.YEAR, 100); //把日期往后增加 100 年，整数往后推，负数往前移
    //         endDate = calendar1.getTime();
    //         card.setAmount = amount;
    //     }else if(if_times==0){
    //         //! 年卡
    //         calendar1.add(Calendar.YEAR, 1); //把日期往后增加 1 年，整数往后推，负数往前移
    //         endDate = calendar1.getTime();
    //     }



    //     Card card = new Card();
    //     //! 生成随机card_id (随机数字字符串)
    //     String card_id = RandomStringUtils.randomNumeric(10); //! 10位

    //     //! 设置card, 准备写DB
    //     card.setCard_id(card_id);
    //     card.setBeginTime(beginDate);
    //     card.setEndTime(endDate);
    //     card.setIf_times(if_times);
    //     card.setCard_level(card_level);
    //     card.setAmount(amount);

    //     //! 写db
    //     int add = vipService.add(card);

    //     //! card_id -> gym_member , 更新db
    //     MemberCard mc = new MemberCard; //! 貌似Mybatis 不支持多参数, 只能封装一下了
    //     mc.setMember_id(member_id);
    //     mc.setCard_id(card_id);
    //     int updateVipStatus = vipService.updateVipStatus(member_id,card_id);

    //     System.out.println("插入VIP数据成功");
    //     model.addAttribute("data","购买VIP成功! 会员ID:"+card_id);
    //     return "login"; //TODO 应该返回到用户个人中心, 有待修改
    // }
}
