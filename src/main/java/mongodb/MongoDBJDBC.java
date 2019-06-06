package mongodb;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * 连接数据库，如果指定数据库名称不存在，MongoDB则会自动创建一个新的数据库
 */
public class MongoDBJDBC {

    public static MongoDatabase CreateMongoDB(String dbName){
        try {
            //连接mongodb服务
            MongoClient client = MongoClients.create();
            //连接到数据库
            MongoDatabase mongoDatabase = client.getDatabase(dbName);
            System.out.println("连接成功");
            return mongoDatabase;
        }catch (Exception e){
            System.err.println(e.getClass().getName()+":"+e.getMessage());
        }
        return null;
    }

}
