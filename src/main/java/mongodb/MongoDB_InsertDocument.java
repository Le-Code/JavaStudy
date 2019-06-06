package mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * 插入文档
 */
public class MongoDB_InsertDocument {

    public static void main(String[] args){
        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");

        MongoCollection collection = database.getCollection("col_java");

        /**
         * 插入文档
         */
        Document document = new Document("title","MongoDB")
                .append("description","database")
                .append("likes",100)
                .append("by","fly");
        collection.insertOne(document);
        System.out.println("文档插入成功");

        collection = database.getCollection("user");
        //录入学生1的信息
        Document stu1 = new Document();
        stu1.put("name","jack");
        stu1.put("age",24);
        Document sight1 = new Document();
        sight1.put("left",1.5);
        sight1.put("right",1.2);
        stu1.put("sight",sight1);
        //录入学生2的信息
        Document stu2 = new Document();
        stu2.put("name","lucy");
        stu2.put("age",22);
        Document sight2 = new Document();
        sight2.put("left",1.0);
        sight2.put("right",1.3);
        stu2.put("sight",sight2);

        collection.insertOne(stu1);
        collection.insertOne(stu2);
    }

}
