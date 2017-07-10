package com.icec.service.impl;

import com.icec.mapper.MobileEquipmentIdentityMapper;
import com.icec.modal.MobileEquipmentIdentity;
import com.icec.service.MobileEquipmentIdentityService;
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
}
