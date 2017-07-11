package com.icec.service.impl;

import com.icec.enums.PhoneStockImportEnum;
import com.icec.mapper.MobileEquipmentIdentityMapper;
import com.icec.modal.MobileEquipmentIdentity;
import com.icec.service.MobileEquipmentIdentityService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
public class MobileEquipmentIdentityServiceImpl implements MobileEquipmentIdentityService {


    @Resource
    private MobileEquipmentIdentityMapper mobileEquipmentIdentityMapper;

    @Override
    public void insert(MobileEquipmentIdentity phoneStock) {
        mobileEquipmentIdentityMapper.insert(phoneStock);
    }

    @Override
    public List<MobileEquipmentIdentity> getAll() {
        return mobileEquipmentIdentityMapper.getAll();
    }

    @Override
    public MobileEquipmentIdentity find(Long id) {
        return mobileEquipmentIdentityMapper.find(id);
    }

    @Override
    public MobileEquipmentIdentity findBySerialNumber(String serialNumber) {
        return mobileEquipmentIdentityMapper.findBySerialNumber(serialNumber);
    }

    @Override
    public void update(MobileEquipmentIdentity phoneStock) {
        mobileEquipmentIdentityMapper.update(phoneStock);
    }

    @Override
    public void delete(Long id) {
        mobileEquipmentIdentityMapper.delete(id);
    }


    @Override
    public String querySerialNumber(String serialNumber) {
        String result = "查无信息";
        MobileEquipmentIdentity entity = findBySerialNumber(serialNumber);
        if (entity != null) {
            result = String.format("移动串号：%s\n机器名：%s\n是否导入：%s\n是否已报深度机型：%s",
                    entity.getSerialNumber(),
                    entity.getName(),
                    entity.getIsImport().getValue(),
                    entity.getModel());
        }
        return result;
    }


    @Override
    public void insert(List<MobileEquipmentIdentity> list) {
        list.forEach(ele -> mobileEquipmentIdentityMapper.insert(ele));
    }


    @Override
    public List<MobileEquipmentIdentity> excelRender(Workbook workbook) {
        List<MobileEquipmentIdentity> dataList = new ArrayList<>();
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
            PhoneStockImportEnum enums = PhoneStockImportEnum.getByValue(c3.getStringCellValue());
            MobileEquipmentIdentity p = new MobileEquipmentIdentity(c1.getStringCellValue(), new DecimalFormat("0").format(c2.getNumericCellValue()) , enums, c4.getStringCellValue());
            dataList.add(p);
        });
        return dataList;
    }

    @Override
    public int batchInsert(Workbook workbook) {
        List<MobileEquipmentIdentity> dataList = excelRender(workbook);
        insert(dataList);
        return dataList.size();
    }

}
