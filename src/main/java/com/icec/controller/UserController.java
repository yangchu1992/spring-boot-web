package com.icec.controller;

import com.github.pagehelper.PageHelper;
import com.icec.modal.Result;
import com.icec.modal.User;
import com.icec.service.UserService;
import com.icec.util.ResultUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/user/list")
    public Result getList() {
        PageHelper.startPage(1, 3);
        return ResultUtils.success(userService.getAll());
    }

    @PostMapping(value = "/user")
    public Result postUser(@Valid User u, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        userService.insert(u);
        return ResultUtils.success(u);
    }

    @PutMapping(value = "/user")
    public Result putUser(@Valid User u, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        userService.update(u);
        return ResultUtils.success(u);
    }

    @DeleteMapping(value = "/user/{id}")
    public Result deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResultUtils.success();
    }

}
