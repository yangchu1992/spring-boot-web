package com.icec.util;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class XmlTool {
    private static final Log logger = LogFactory.getLog(XmlTool.class);
    private static XStream xstream;
    private static List<String> CDATA_FIELD = new ArrayList<String>();
    private static List<Class<?>> CLASS_ARRAY = new ArrayList<Class<?>>();
    private static final String[] packageUrlArray = new String[]{"com.icec.modal"};

    static{
        List<String> nameOfClasses = new ArrayList<String>();
        for(String packageUrl : packageUrlArray){
            if(StringUtils.isEmpty(packageUrl)){
                continue;
            }
            Set<String> result = ClassTool.getClassName(packageUrl, false);
            if(result != null && result.size() > 0){
                nameOfClasses.addAll(result);
            }
        }
        if(nameOfClasses != null && nameOfClasses.size() > 0){
            for(String nameOfClass : nameOfClasses){
                try {
                    Class<?> myClass = Class.forName(nameOfClass);
                    CLASS_ARRAY.add(myClass);
                    //获取自定义注解的属性集合
                    Field[] fieldArray = myClass.getDeclaredFields();
                    if(fieldArray != null && fieldArray.length > 0){
                        for(Field field : fieldArray){
                            if(field != null && field.isAnnotationPresent(XStreamCDATA.class)){
                                CDATA_FIELD.add(field.getName());
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    logger.error("XmlTool.java **XStream** init failed！");
                    e.printStackTrace();
                }
            }
        }
        //实例化XStream对象
        xstream = new XStream(new CustomizedDomDriver(CDATA_FIELD));
        //处理自带注解
        if(CLASS_ARRAY != null && CLASS_ARRAY.size() > 0){
            for(Class<?> myClass : CLASS_ARRAY){
                if(myClass != null){
                    xstream.processAnnotations(myClass);
                }
            }
        }
    }

    /**
     * xml转为对象
     * @param xml
     * @return
     */
    public static Object parseXmlToObj(String xml, @SuppressWarnings("rawtypes") Class type){
        xstream.alias("xml", type);
        return xstream.fromXML(xml);
    }

    /**
     * 对象转为xml
     * @param obj
     * @return
     */
    public static String parseObjToXml(Object obj){
        xstream.alias("xml", obj.getClass());
        return xstream.toXML(obj);
    }
}
