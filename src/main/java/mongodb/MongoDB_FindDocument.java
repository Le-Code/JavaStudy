package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDB_FindDocument {

    public static void main(String[] args){

        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");

        MongoCollection<Document> collection = database.getCollection("col_java");

        /**
         * 检索所有的文档
         */
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println();

        collection = database.getCollection("user");
        //==条件
        System.out.println("==============");
        BasicDBObject query = new BasicDBObject();
        query.put("name","jack");
        findIterable = collection.find(query);
        cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //查询age小于30，age不等于20的对象
        System.out.println("==========");
        query = new BasicDBObject();
        query.put("age",new BasicDBObject("$lt",30));
        query.put("age",new BasicDBObject("$ne",20));
        findIterable = collection.find(query);
        cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

    }

}
