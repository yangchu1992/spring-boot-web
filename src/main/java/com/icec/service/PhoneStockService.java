package com.icec.service;

import com.icec.modal.PhoneStock;

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
public interface PhoneStockService {

    void insert(PhoneStock phoneStock);

    List<PhoneStock> getAll();

    PhoneStock find(Long id);

    PhoneStock findBySerialNumber(String serialNumber);

    void update(PhoneStock phoneStock);

    void delete(Long id);

    /**
     * 查询机器
     * @param serialNumber 移动串号
     * @return
     */
    String querySerialNumber(String serialNumber);

}
