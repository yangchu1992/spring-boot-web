package com.icec.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.icec.modal.ImeiInfo;
import com.icec.modal.Result;
import com.icec.service.ImeiInfoService;
import com.icec.util.ResultUtils;
import com.icec.util.StringUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Api(value = "手机IMEI导入信息")
public class ImeiInfoController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ImeiInfoController.class);

    @Resource
    private ImeiInfoService imeiInfoService;

    @ApiOperation(value="获取手机IMEI信息列表")
    @GetMapping(value = "/imei/list")
    public Result<List> getList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        imeiInfoService.getAll();
        Map map = new HashMap<>();
        map.put("list", page);
        map.put("total", page.getTotal());
        return ResultUtils.success(map);
    }


    @GetMapping(value = "/imei")
    public Result getImei(@RequestParam String serialNumber) {
        return ResultUtils.success(imeiInfoService.querySerialNumber(serialNumber));
    }


    @ApiOperation(value="创建手机IMEI信息", notes="")
    @PostMapping(value = "/imei")
    public Result postImei(@Valid ImeiInfo m, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        imeiInfoService.insert(m);
        return ResultUtils.success(m);
    }

    @ApiOperation(value = "更新单个记录", notes = "更新手机IMEI信息")
    @PutMapping(value = "/imei")
    public Result putImei(@Valid ImeiInfo m, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtils.error(100, bindingResult.getFieldError().getDefaultMessage());
        }
        imeiInfoService.update(m);
        return ResultUtils.success(m);
    }

    @ApiOperation(value = "删除单个记录", notes = "根据url删除手机IMEI")
    @DeleteMapping(value = "/imei")
    public Result deleteImei(@RequestParam Long id){
        imeiInfoService.delete(id);
        return ResultUtils.success();
    }

    @ApiOperation(value = "删除多条记录", notes = "根据url删除手机IMEI")
    @DeleteMapping(value = "/imei/batch")
    public Result deleteImei(@RequestParam String ids) {
        List<String> list = StringUtil.str2Array(ids, ",");
        list.forEach((s)-> {
            imeiInfoService.delete(Long.valueOf(s));
        });
        return ResultUtils.success();
    }


    @PostMapping(value = "/imei/batch")
    public Result postExcel(@RequestParam("upload") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtils.error(EMPTY_FILE.getCode(), EMPTY_FILE.getMsg());
        }

        String filename = file.getOriginalFilename();

        Workbook workbook = null;
        try {
            if (filename.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (filename.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                return ResultUtils.error(ERROR_FORMAT_FILE.getCode(), ERROR_FORMAT_FILE.getMsg());
            }
            return ResultUtils.success(imeiInfoService.batchInsert(workbook));
        } catch (IOException e) {
            return ResultUtils.error(IO_EXCEPTION.getCode(), IO_EXCEPTION.getMsg());
        }
    }


}
