package com.icec.service.impl;

import com.icec.mapper.PhoneStockMapper;
import com.icec.modal.PhoneStock;
import com.icec.service.PhoneStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
public class PhoneStockServiceImpl implements PhoneStockService {


    @Resource
    private PhoneStockMapper phoneStockMapper;

    @Override
    public void insert(PhoneStock phoneStock) {
        phoneStockMapper.insert(phoneStock);
    }

    @Override
    public List<PhoneStock> getAll() {
        return phoneStockMapper.getAll();
    }

    @Override
    public PhoneStock find(Long id) {
        return phoneStockMapper.find(id);
    }

    @Override
    public PhoneStock findBySerialNumber(String serialNumber) {
        return phoneStockMapper.findBySerialNumber(serialNumber);
    }

    @Override
    public void update(PhoneStock phoneStock) {
        phoneStockMapper.update(phoneStock);
    }

    @Override
    public void delete(Long id) {
        phoneStockMapper.delete(id);
    }


    public String querySerialNumber(String serialNumber) {
        String result = "查无信息";
        PhoneStock phoneStock = findBySerialNumber(serialNumber);
        if (phoneStock != null) {
            result = String.format("移动串号：%s\n机器名：%s\n是否导入：%s\n是否已报深度机型：%s",
                    phoneStock.getSerialNumber(),
                    phoneStock.getName(),
                    phoneStock.getIsImport().getValue(),
                    phoneStock.getModel());
        }
        return result;
    }
}
