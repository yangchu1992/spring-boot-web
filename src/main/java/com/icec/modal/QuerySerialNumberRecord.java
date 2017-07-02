package com.icec.modal;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by jqChu on 2017/6/27.
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
public class QuerySerialNumberRecord {
    private Long id;
    private String serialNumber;
    private String fromUsername;
    private Timestamp stamp;

    public QuerySerialNumberRecord() {
        super();
    }

    public QuerySerialNumberRecord(String serialNumber, String fromUsername, Timestamp stamp) {
        this();
        this.serialNumber = serialNumber;
        this.fromUsername = fromUsername;
        this.stamp = stamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public Timestamp getStamp() {
        return stamp;
    }

    public void setStamp(Timestamp stamp) {
        this.stamp = stamp;
    }

    @Override
    public String toString() {
        return "QuerySerialNumberRecord{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", fromUsername='" + fromUsername + '\'' +
                ", stamp=" + stamp +
                '}';
    }
}
