package com.knoldus.KafkaClasses;

import com.knoldus.UserPojo.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    public static void main(String[] args) {

        Properties p=new Properties();
        p.put("bootstrap.servers","localhost:9092");
        p.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        p.put("value.serializer","com.knoldus.SerializedDeserialized.ObjectSerialization");


      KafkaProducer<String,User> kp=new KafkaProducer<String, User>(p);

   
      User user1=new User(101,22,"Shekhar","B.Tech");
      User user2=new User(102,23,"Sachin","M.Tech");




       try {

           kp.send(new ProducerRecord("User",user1));
           kp.send(new ProducerRecord("User",user2));



       }
       catch (Exception e)
       {
           System.out.println("Exception:"+e);
       }
       finally {
           kp.close();
       }


    }

}
