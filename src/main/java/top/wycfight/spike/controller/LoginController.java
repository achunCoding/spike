package top.wycfight.spike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wycfight.spike.dto.LoginDTO;
import top.wycfight.spike.service.UserService;
import top.wycfight.spike.util.Result;
import top.wycfight.spike.util.ResultGenerator;

import javax.validation.Valid;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-12-04 21:39
 * @modify By:
 **/
@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "admin/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@Valid LoginDTO loginDTO) {
        log.info("请求参数 loginDTO :{}", loginDTO.toString());
        String userMsg = userService.login(loginDTO);
        if (!"OK".equals(userMsg)) {
            return ResultGenerator.genErrorResult(10004, userMsg);
        }
        return ResultGenerator.genSuccessResult();
    }
}
