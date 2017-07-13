package com.icec.service.impl;

import com.icec.enums.ImeiImportEnum;
import com.icec.mapper.ImeiInfoMapper;
import com.icec.modal.ImeiInfo;
import com.icec.service.ImeiInfoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

/**
 * Created by jqChu on 2017/6/18.
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
@Service
public class ImeiInfoServiceImpl implements ImeiInfoService {


    @Resource
    private ImeiInfoMapper imeiInfoMapper;

    @Override
    public void insert(ImeiInfo phoneStock) {
        imeiInfoMapper.insert(phoneStock);
    }

    @Override
    public List<ImeiInfo> getAll() {
        return imeiInfoMapper.getAll();
    }

    @Override
    public ImeiInfo find(Long id) {
        return imeiInfoMapper.find(id);
    }

    @Override
    public ImeiInfo findBySerialNumber(String serialNumber) {
        return imeiInfoMapper.findBySerialNumber(serialNumber);
    }

    @Override
    public void update(ImeiInfo phoneStock) {
        imeiInfoMapper.update(phoneStock);
    }

    @Override
    public void delete(Long id) {
        imeiInfoMapper.delete(id);
    }


    @Override
    public String querySerialNumber(String serialNumber) {
        String result = "查无信息";
        ImeiInfo entity = findBySerialNumber(serialNumber);
        if (entity != null) {
            result = String.format("移动串号：%s\n机器名：%s\n是否导入：%s\n是否已报深度机型：%s\n移动机型：%s",
                    entity.getSerialNumber(),
                    entity.getName(),
                    entity.getIsImport().getValue(),
                    entity.getModel(),
                    entity.getMobileType());
        }
        return result;
    }


    @Override
    public void insert(List<ImeiInfo> list) {
        Map<String, ImeiInfo> imeiInfoMap = getMapBySerialNumber();
        list.forEach(ele -> {
            if(imeiInfoMap.containsKey(ele.getSerialNumber())) {
                ele.setId(imeiInfoMap.get(ele.getSerialNumber()).getId());
                imeiInfoMapper.update(ele);
            } else {
                imeiInfoMapper.insert(ele);
            }
        });
    }


    @Override
    public List<ImeiInfo> excelRender(Workbook workbook) {
        List<ImeiInfo> dataList = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        sheet.forEach(row-> {
            //跳过标题栏
            if (row.getRowNum() == 0) {
                return;
            }
            Cell c1 = row.getCell(0);
            Cell c2 = row.getCell(1);
            Cell c3 = row.getCell(2);
            Cell c4 = row.getCell(3, CREATE_NULL_AS_BLANK);
            Cell c5 = row.getCell(4, CREATE_NULL_AS_BLANK);
            ImeiImportEnum enums = ImeiImportEnum.getByValue(c3.getStringCellValue());
            ImeiInfo p = new ImeiInfo(c1.getStringCellValue(), new DecimalFormat("0").format(c2.getNumericCellValue()) , enums, c4.getStringCellValue(), c5.getStringCellValue());
            dataList.add(p);
        });
        return dataList;
    }

    @Override
    public int batchInsert(Workbook workbook) {
        List<ImeiInfo> dataList = excelRender(workbook);
        insert(dataList);
        return dataList.size();
    }

    @Override
    public Map<String, ImeiInfo> getMapBySerialNumber() {
        List<ImeiInfo> all = getAll();
        return all.stream().collect(Collectors.toMap(ImeiInfo::getSerialNumber, imeiInfo -> imeiInfo));
    }

}
