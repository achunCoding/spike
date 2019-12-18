package top.wycfight.spike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.wycfight.spike.entity.GoodsVO;
import top.wycfight.spike.entity.User;
import top.wycfight.spike.service.GoodsService;
import top.wycfight.spike.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 商品Controller
 * @create: 2019-12-10 22:01
 * @modify By:
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询秒杀商品列表
     *
     * @param result
     * @param user
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toLogin(Map<String, Object> result, User user) {
        List<GoodsVO> goodsList = goodsService.list();
        result.put("goods", goodsList);
        return "goods/goods_list";
    }

    @RequestMapping(value = "/detail/{goodId}", method = RequestMethod.GET)
    public String detail(Map<String, Object> result, User user, @PathVariable(value = "goodId") Long goodId) {
        GoodsVO good = goodsService.searchGoodById(goodId);
        long startTime = good.getStartDate().getTime();
        long endTime = good.getEndDate().getTime();
        long nowTime = System.currentTimeMillis();
        int spikeStatus;
        int remainSeconds;
        if (nowTime < startTime) {
            // 秒杀没有开始
            spikeStatus = 0;
            remainSeconds = (int) ((startTime - nowTime) / 1000);
        } else if (nowTime < endTime) {
            // 秒杀正在进行中
            spikeStatus = 2;
            remainSeconds = 0;
        } else {
            //秒杀已经结束
            spikeStatus = 1;
            remainSeconds = -1;
        }
        result.put("good", good);
        result.put("spikeStatus", spikeStatus);
        result.put("remainSeconds",remainSeconds);
        result.put("user",user);
        return "goods/goods_detail";
    }
}
