package com.example.shishaapp.Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class MongoDB {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017"; //connection string
        String databaseName = "mydb";
        String collectionName = "users";

        Document[] users = {
                new Document("name", "John"),
                new Document("name", "Jane"),
                new Document("name", "David"),
                new Document("name", "Emily"),
                new Document("name", "Michael")
        };

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            collection.insertMany(Arrays.asList(users));
        } //connects to MongoDB, accesses a specific database, and inserts multiple users
    }
}
