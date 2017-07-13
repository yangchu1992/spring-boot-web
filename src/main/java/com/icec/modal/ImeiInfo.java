package com.icec.modal;

import com.icec.enums.ImeiImportEnum;
import org.springframework.stereotype.Component;

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
@Component
public class ImeiInfo {

    private Long id;
    private String name;
    private String serialNumber;
    private ImeiImportEnum isImport;
    private String model;

 

    private String mobileType;

    public ImeiInfo() {
        super();
    }

    public ImeiInfo(String name, String serialNumber, ImeiImportEnum isImport, String model, String mobileType) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isImport = isImport;
        this.model = model;
        this.mobileType = mobileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ImeiImportEnum getIsImport() {
        return isImport;
    }

    public void setIsImport(ImeiImportEnum isImport) {
        this.isImport = isImport;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
   
    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    @Override
    public String toString() {
        return "ImeiInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", isImport=" + isImport +
                ", model='" + model + '\'' +
                ", mobileType='" + mobileType + '\'' +
                '}';
    }
}
