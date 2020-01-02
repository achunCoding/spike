package top.wycfight.spike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.wycfight.spike.entity.User;
import top.wycfight.spike.service.GoodsService;

/**
 * @author: wycfight@163.com
 * @description: 秒杀Contoller
 * @create: 2019-12-19 07:25
 * @modify By:
 **/
@Controller
@RequestMapping("spike")
public class SpikeController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("spike")
    public String list(User user, @RequestParam(value = "goodsId")Long goodsId) {
        // 判断是否有库存


        // 判断用户是否已经秒杀过商品信息


        // 进行秒杀  减库存，写订单，



        return "";
    }
}
