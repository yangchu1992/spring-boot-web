package com.icec.service;

import com.icec.modal.ImeiInfo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

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
public interface ImeiInfoService {

    void insert(ImeiInfo entity);


    void insert(List<ImeiInfo> list);

    List<ImeiInfo> getAll();

    ImeiInfo find(Long id);

    ImeiInfo findBySerialNumber(String serialNumber);

    void update(ImeiInfo entity);

    void delete(Long id);

    /**
     * 查询机器
     * @param serialNumber 移动串号
     * @return
     */
    String querySerialNumber(String serialNumber);

    List<ImeiInfo> excelRender(Workbook workbook);

    int batchInsert(Workbook workbook);

    Map<String, ImeiInfo> getMapBySerialNumber();



}
