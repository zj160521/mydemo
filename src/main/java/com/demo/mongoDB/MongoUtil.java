package com.demo.mongoDB;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

//mongodb 连接数据库工具类
public class MongoUtil {
    public static MongoDatabase getConnect(){
        //root:root 账号：密码
        MongoClientURI uri = new MongoClientURI("mongodb://root:root@192.169.7.20:27017/gm");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        return db;
    }
}


