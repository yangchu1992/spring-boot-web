package com.icec.modal;

import com.icec.enums.PhoneStockImportEnum;
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
public class MobileEquipmentIdentity {

    private Long id;
    private String name;
    private String serialNumber;
    private PhoneStockImportEnum isImport;
    private String model;

    public MobileEquipmentIdentity() {
        super();
    }

    public MobileEquipmentIdentity(String name, String serialNumber, PhoneStockImportEnum isImport, String model) {
        this();
        this.name = name;
        this.serialNumber = serialNumber;
        this.isImport = isImport;
        this.model = model;
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

    public PhoneStockImportEnum getIsImport() {
        return isImport;
    }

    public void setIsImport(PhoneStockImportEnum isImport) {
        this.isImport = isImport;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "MobileEquipmentIdentity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", isImport=" + isImport +
                ", model='" + model + '\'' +
                '}';
    }
}
