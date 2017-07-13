package com.icec.enums;

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
public enum ImeiImportEnum {
    UNABLE("不能导入"), DONE("已导入"), UNDONE("未导入");

    private final String value;

    ImeiImportEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ImeiImportEnum getByValue(String str) {
        ImeiImportEnum[] values = ImeiImportEnum.values();
        for(ImeiImportEnum v : values) {
            if (v.getValue().equals(str)) {
                return v;
            }
        }
        return null;
    }

}
