package mongodb;

import com.mongodb.client.MongoDatabase;

/**
 * 创建集合
 */
public class MongoDB_CreateCollection {

    public static void main(String[] args){
        //获取连接
        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");
        //创建集合,若已经存在则会抛出异常
        database.createCollection("col2_java");
        System.out.println("创建集合成功");
    }

}
