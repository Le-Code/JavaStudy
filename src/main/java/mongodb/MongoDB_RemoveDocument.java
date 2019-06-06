package mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDB_RemoveDocument {

    public static void main(String[] args){

        MongoDatabase database = MongoDBJDBC.CreateMongoDB("runoob");

        MongoCollection<Document> collection = database.getCollection("col_java");
        //删除符合条件的第一个文档
        collection.deleteOne(Filters.eq("likes",200));

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

}
