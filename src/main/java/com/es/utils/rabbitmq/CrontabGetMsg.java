package com.es.utils.rabbitmq;

import com.es.config.RabbitmqConf;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

@Component
public class CrontabGetMsg {

    @Autowired
    private AmqpTemplate amqp;


    //秒 分 时 日 月 周 年
    //每五秒接收一次消息
    @Scheduled(cron="0/5 * * ? * *")
    public void getMsg()
    {
        //System.out.println("getMsg() "+new java.sql.Timestamp(System.currentTimeMillis()));
        try
        {
            //每次接收一个消息
            Message msg = amqp.receive(RabbitmqConf.QUEUE1);
            //如果消息为空，返回
            if(msg == null)
                return;
            byte[] data = msg.getBody();
            //反序列化消息为对象
            Object obj = toObject(data);
         /*   if(obj instanceof MenuInfo)
            {
                MenuInfo mi = (MenuInfo)obj;
                String sid = mi.getSid();
                Integer id = mi.getId();
                System.out.println("getMsg id="+id+",name="+mi.getName());
                if(id == null)//新增
                {
                    serv.saveMenu(mi);
                }
                else//更新
                {
                    serv.updateMenu(mi);
                    //删除原来关联中间表数据
                    serv.deleteM2S(mi.getId());
                }
                String[] dim = sid.split(",");
                for(String sid2:dim)
                {
                    M2SInfo m2s = new M2SInfo();
                    m2s.setSid(new Integer(sid2));
                    m2s.setMid(mi.getId());
                    serv.saveM2S(m2s);
                }
            }*/
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Object toObject(byte[] data)
    {
        try
        {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            bais.close();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
