package com.icec.util;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.Writer;
import java.util.List;

/**
 * Created by jqChu on 2017/6/26.
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
public class CustomizedDomDriver extends DomDriver{
    private List<String> CDATA_FIELDS;
    private static XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("_-", "_");
    /**
     * 构造函数
     * @param _CDATA_FIELDS
     */
    public CustomizedDomDriver(List<String> _CDATA_FIELDS){
        this.CDATA_FIELDS = _CDATA_FIELDS;
    }

    @Override
    public HierarchicalStreamWriter createWriter(Writer out){
        return new PrettyPrintWriter(out, nameCoder){
            boolean cdata = false;
            public void startNode(String name){
                super.startNode(name);
                cdata = CDATA_FIELDS.contains(name);
            }

            protected void writeText(QuickWriter writer, String text){
                if (cdata){
                    writer.write("<![CDATA[");
                    writer.write(text);
                    writer.write("]]>");
                }else{
                    writer.write(text);
                }
            }
        };
    }

}
