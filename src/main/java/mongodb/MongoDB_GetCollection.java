package mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 获取集合
 */
public class MongoDB_GetCollection {

    public static void main(String[] args){

        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");

        MongoCollection collection = database.getCollection("col_java2");

        System.out.println("集合 test 获取成功");
    }

}
