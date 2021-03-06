package com.demo.mongoDB;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Map;
import java.util.regex.Pattern;

public class mongoTest {

    public static void main(String[] args) {
        MongoCollection collection = MongoUtil.getConnect().getCollection("activity_stat");
        // 按字段查询记录
        FindIterable findIterable = collection.find(Filters.eq("time","2019-02-02"));
        MongoCursor cursor = findIterable.iterator();
        if (cursor.hasNext()) {
            Document document = (Document)cursor.next();
            System.out.println(document);
        }

        // 添加
//        collection.insertOne(new Document().append("time","2019-02-01"));

        // 更新，有num字段就更新，没有就新增
//        collection.updateOne(Filters.eq("time","2019-02-01"), new Document("$set",new Document("num","100")));

        // 条件查询，结果排序
        // 查询条件方式一
//        BasicDBObject cond =  new BasicDBObject();
//        cond.append("time",new BasicDBObject("$gte","2019-02-01"));
//        cond.append("time",new BasicDBObject("$lte","2019-02-02"));
        // 方式二
//        Bson query = Filters.and(
//                Filters.gte("time", "2019-02-01"),
//                Filters.lte("time", "2019-02-02"));
//        FindIterable findIterable1 = collection.find(cond).sort(Sorts.descending("time"));
        // 模糊查询
//        Pattern pattern = Pattern.compile("^"+para.getTime()+".*$");
//        FindIterable findIterable = collection.find(Filters.regex(firstDepositTime,pattern));
//        MongoCursor cursor1 = findIterable1.iterator();
//        while (cursor1.hasNext()) {
//            Document document = (Document)cursor.next();
//            for (Map.Entry<String,Object> entry: document.entrySet()) {
//
//            }
//        }
    }
}
