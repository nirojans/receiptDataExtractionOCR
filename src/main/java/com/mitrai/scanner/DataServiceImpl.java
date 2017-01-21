package com.mitrai.scanner;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by nirojans on 1/12/17.
 */
public class DataServiceImpl {

    public static String manualDataDB;
    public static String manualDataTescoCollection;
    public static String manualDataSaintsCollection;

    public static String ocrDB;
    public static String ocrReceiptCollection;

    static {
        Properties properties = Configs.getConfigs(Configs.CONFIG_FILE_NAME);
        manualDataDB = properties.getProperty("ocrReceiptDB");
        manualDataTescoCollection = properties.getProperty("tesco");
        manualDataSaintsCollection = properties.getProperty("ocrSaintsReceiptCollection");

        ocrDB = properties.getProperty("manualDataDbName");
        ocrReceiptCollection = properties.getProperty("manualReceiptCollection");
    }


    public static void insertIntoDB(MasterReceipt receipt) throws UnknownHostException {

        MongoClient mongo = new MongoClient("localhost", 27017);

        DB db = mongo.getDB("mitra");
        DBCollection col = db.getCollection("receipts");

        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(receipt));
        col.insert(obj);
        mongo.close();
    }

    public static List<ManualReceipt> doFullTextSearchFromManualData(String searchTerm, String collectionName) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB(manualDataDB);
        DBCollection col = db.getCollection(collectionName);

        DBObject search = new BasicDBObject("$text", new BasicDBObject("$search", searchTerm));
        DBObject project = new BasicDBObject("score", new BasicDBObject("$meta", "textScore"));
        DBObject sorting = new BasicDBObject("score", new BasicDBObject("$meta", "textScore"));

        DBCursor cursor = col.find(search, project).sort(sorting);


        List<ManualReceipt> manualReceiptList = new ArrayList<>();

        try {
            while(cursor.hasNext()) {
                DBObject dbObject = cursor.next();
                ManualReceipt manualReceipt = (new Gson()).fromJson(dbObject.toString(), ManualReceipt.class);
                manualReceiptList.add(manualReceipt);
            }
        } finally {
            cursor.close();
            mongo.close();
        }
        return manualReceiptList;
    }

    public static List<ManualReceipt> getReceiptFromManualData(String searchID, String collectionName) throws UnknownHostException {

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB(manualDataDB);
        DBCollection col = db.getCollection(collectionName);

        DBCursor cursor = col.find(new BasicDBObject("TILLROLL_DOC_ID", searchID));
        List<ManualReceipt> manualReceiptList = new ArrayList<>();

        try {
            while(cursor.hasNext()) {
                DBObject dbObject = cursor.next();
                ManualReceipt manualReceipt = (new Gson()).fromJson(dbObject.toString(), ManualReceipt.class);
                manualReceiptList.add(manualReceipt);
            }
        } finally {
            cursor.close();
            mongo.close();
        }
        return manualReceiptList;
    }

}
