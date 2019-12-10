package top.wycfight.spike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wycfight.spike.entity.User;
import top.wycfight.spike.redis.UserKey;
import top.wycfight.spike.service.RedisService;
import top.wycfight.spike.util.Result;
import top.wycfight.spike.util.ResultGenerator;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-11-28 21:09
 * @modify By:
 **/
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/demo")
    public String demo() {
        return "hello";
    }

    @RequestMapping(value = "/redis/get")
    @ResponseBody
    public Result redisGet() {
        User user = redisService.get(UserKey.getById , "1", User.class);
        return ResultGenerator.genSuccessResult(user);
    }
    @RequestMapping(value = "/redis/set")
    @ResponseBody
    public Result redisSet() {
        User user = new User();
        user.setId(1L);
        redisService.set(UserKey.getById, "" + 1, user);
        User result = redisService.get(UserKey.getById , "1", User.class);
        return ResultGenerator.genSuccessResult(result);
    }
}
