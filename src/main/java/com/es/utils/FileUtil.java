package com.es.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtil {


    private static  Logger logger = LoggerFactory.getLogger(FileUtil.class);

    //读取txt文件内容
    public static String getContext(File file)throws  IOException{
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(file)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        if(line!=null)
        {
            StringBuffer json = new StringBuffer(line);
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if(line!=null)
                {
                    json.append(line);
                }
            }
            br.close();
            logger.info("-------------readFile---------------:"+json.toString());
            return  json.toString();
        }
        return "";
    }
}
