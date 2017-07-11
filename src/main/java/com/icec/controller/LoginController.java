package com.icec.controller;

import com.icec.modal.Result;
import com.icec.modal.User;
import com.icec.service.UserService;
import com.icec.util.ResultUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by jqChu on 2017/6/17.
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {

    @Resource
    private UserService userService;


    @PostMapping(value = "/login")
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResultUtils.error(101, "用户名密码不能为空");
        }
        User u = userService.findByName(username);
        if (u != null && u.getPassword().equals(password)) {
            return ResultUtils.success(u);
        }
        return ResultUtils.error(102, "用户名或密码错误");
    }


}
