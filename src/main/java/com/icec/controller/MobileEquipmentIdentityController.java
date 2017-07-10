package com.icec.controller;

import com.github.pagehelper.PageHelper;
import com.icec.modal.MobileEquipmentIdentity;
import com.icec.modal.Result;
import com.icec.service.impl.MobileEquipmentIdentityServiceImpl;
import com.icec.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user/mobile-equipment-identity")
@Api(value = "手机IMEI导入信息")
public class MobileEquipmentIdentityController {

    @Resource
    private MobileEquipmentIdentityServiceImpl mobileEquipmentIdentityService;

    @ApiOperation(value="获取手机IMEI信息列表")
    @GetMapping(value = "/list")
    public List<MobileEquipmentIdentity> list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mobileEquipmentIdentityService.getAll();
    }


    @ApiOperation(value = "删除手机", notes = "根据url删除手机IMEI")
    @DeleteMapping(value = "/{id}")
    public Result deletePhoneStock(@PathVariable Long id){
        mobileEquipmentIdentityService.delete(id);
        return ResultUtils.success();
    }


}
