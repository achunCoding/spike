package top.wycfight.spike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-11-28 21:09
 * @modify By:
 **/
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/demo")
    public String demo() {
        return "hello";
    }
}
