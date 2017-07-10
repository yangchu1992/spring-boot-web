package com.icec.service;

import com.icec.modal.MobileEquipmentIdentity;

import java.util.List;

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
public interface MobileEquipmentIdentityService {

    void insert(MobileEquipmentIdentity entity);

    List<MobileEquipmentIdentity> getAll();

    MobileEquipmentIdentity find(Long id);

    MobileEquipmentIdentity findBySerialNumber(String serialNumber);

    void update(MobileEquipmentIdentity entity);

    void delete(Long id);

    /**
     * 查询机器
     * @param serialNumber 移动串号
     * @return
     */
    String querySerialNumber(String serialNumber);

}
