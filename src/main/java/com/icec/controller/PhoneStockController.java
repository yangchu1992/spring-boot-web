package com.icec.controller;

import com.github.pagehelper.PageHelper;
import com.icec.modal.PhoneStock;
import com.icec.service.impl.PhoneStockServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
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
 *
 */
@RestController
@RequestMapping("/user/phoneStock")
@Api(value = "手机库存信息")
public class PhoneStockController {

    @Resource
    private PhoneStockServiceImpl phoneStockService;

    @ApiOperation(value="获取手机库存信息", notes="")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PhoneStock> list() {
        PageHelper.startPage(1,5);
        return phoneStockService.getAll();
    }

}
