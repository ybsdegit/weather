package com.ybs.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XmlBuilder
 * 将字符串转换为指定类型的pojo
 * @author Paulson
 * @date 2020/1/9 0:40
 */
public class XmlBuilder {
    public static Object xmlStrToObject(Class<?> clazz, String  xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        // xml 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);

        xmlObject = unmarshaller.unmarshal(reader);

        if (reader != null){
            reader.close();
        }

        return xmlObject;
    }
}
