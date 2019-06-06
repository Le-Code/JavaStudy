package mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDB_UpdateDocument {

    public static void main(String[] args){

        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");

        MongoCollection<Document> collection = database.getCollection("col_java");

        /**
         * 更新文档
         */
        collection.updateMany(Filters.eq("likes",100),new Document("$set",new Document("likes",200)));

        //查看更新结果
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

    }

}
