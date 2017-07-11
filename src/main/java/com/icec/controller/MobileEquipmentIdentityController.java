package com.icec.controller;

import com.github.pagehelper.PageHelper;
import com.icec.modal.MobileEquipmentIdentity;
import com.icec.modal.Result;
import com.icec.service.MobileEquipmentIdentityService;
import com.icec.service.impl.MobileEquipmentIdentityServiceImpl;
import com.icec.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.icec.enums.ResultEnum.EMPTY_FILE;
import static com.icec.enums.ResultEnum.ERROR_FORMAT_FILE;
import static com.icec.enums.ResultEnum.IO_EXCEPTION;


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
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "手机IMEI导入信息")
public class MobileEquipmentIdentityController {


    private static final Logger LOGGER = LoggerFactory.getLogger(MobileEquipmentIdentityController.class);

    @Resource
    private MobileEquipmentIdentityService mobileEquipmentIdentityService;

    @ApiOperation(value="获取手机IMEI信息列表")
    @GetMapping(value = "/mobile-equipment-identity/list")
    public Result<List> getList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResultUtils.success(mobileEquipmentIdentityService.getAll());
    }


    @ApiOperation(value="创建手机IMEI信息", notes="")
    @PostMapping(value = "/mobile-equipment-identity")
    public Result postUser(@Valid MobileEquipmentIdentity m, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        mobileEquipmentIdentityService.insert(m);
        return ResultUtils.success(m);
    }

    @ApiOperation(value = "更新单个记录", notes = "更新手机IMEI信息")
    @PutMapping(value = "/mobile-equipment-identity")
    public Result putIdentity(@Valid MobileEquipmentIdentity m, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        mobileEquipmentIdentityService.update(m);
        return ResultUtils.success(m);
    }

    @ApiOperation(value = "删除单个记录", notes = "根据url删除手机IMEI")
    @DeleteMapping(value = "/mobile-equipment-identity/{id}")
    public Result deleteIdentity(@PathVariable Long id){
        mobileEquipmentIdentityService.delete(id);
        return ResultUtils.success();
    }


    @PostMapping(value = "/mobile-equipment-identity/excel")
    public Result postExcel(@RequestParam("upload") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtils.error(EMPTY_FILE);
        }

        String filename = file.getOriginalFilename();

        Workbook workbook = null;
        try {
            if (filename.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (filename.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                return ResultUtils.error(ERROR_FORMAT_FILE);
            }
            return ResultUtils.success(mobileEquipmentIdentityService.batchInsert(workbook));
        } catch (IOException e) {
            return ResultUtils.error(IO_EXCEPTION);
        }
    }


}
