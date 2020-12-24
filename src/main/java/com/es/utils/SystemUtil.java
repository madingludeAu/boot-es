package com.es.utils;

import java.lang.reflect.Field;
import java.util.Map;

public class SystemUtil {

    /**
     * 对象转map
     * @param o
     * @param map
     * @return
     */
    public Map ObjectTOMap(Object o, Map map){
        for (Field field : o.getClass().getDeclaredFields()){
            field.setAccessible(true); // 设置些属性是可以访问的
            //  String type = field.getType().toString();// 得到此属性的类型
            String key = field.getName();// key:得到属性名
            Object value = null;// 得到此属性的值
            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(value!=null){
                map.put(key,value);
            }
        }
        return  map;
    }
}
