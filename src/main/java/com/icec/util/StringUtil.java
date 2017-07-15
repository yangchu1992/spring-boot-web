package com.icec.util;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jqchu on 2017/7/15.
 */
public class StringUtil {

    /**
     * string字符串分割成list
     * @param str 需要被分割的字符串
     * @param separator 分离器
     * @return
     */
    public static List str2Array(String str, String separator) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        String temp = str;
        List list = new ArrayList<>();
        int index = 0;
        while ((index = temp.indexOf(separator))!=-1) {
            String splitStr = temp.substring(0, index);
            list.add(splitStr);
            temp = temp.substring(index+1);
        }
        if (!temp.isEmpty()) list.add(temp);
        return list;
    }
}
