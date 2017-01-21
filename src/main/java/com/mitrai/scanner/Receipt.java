package com.mitrai.scanner;

import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niro273 on 1/11/17.
 */
public class Receipt implements Serializable {

    // Image name is considered to be the receipt name
    private String id;
    private String superMarketName;
    private int nameRecognitionRank;

    private ArrayList<LineItem> lineItems = new ArrayList<>();
    private List<String> possibleLineItems;

    private String date;
    private String time;
    private String otherValues;
    private String[] rawData;
    private List unclassifiedLineItemNumbers;

    private int lineItemEndLine;
    private int lineItemStartLine;
    private int preprocessMethod;

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOtherValues() {
        return otherValues;
    }

    public void setOtherValues(String otherValues) {
        this.otherValues = otherValues;
    }

    public int getNameRecognitionRank() {
        return nameRecognitionRank;
    }

    public void setNameRecognitionRank(int nameRecognitionRank) {
        this.nameRecognitionRank = nameRecognitionRank;
    }

    public String[] getRawData() {
        return rawData;
    }

    public void setRawData(String[] rawData) {
        this.rawData = rawData;
    }

    public int getLineItemEndLine() {
        return lineItemEndLine;
    }

    public void setLineItemEndLine(int lineItemEndLine) {
        this.lineItemEndLine = lineItemEndLine;
    }

    public int getLineItemStartLine() {
        return lineItemStartLine;
    }

    public void setLineItemStartLine(int lineItemStartLine) {
        this.lineItemStartLine = lineItemStartLine;
    }

    public int getPreprocessMethod() {
        return preprocessMethod;
    }

    public void setPreprocessMethod(int preprocessMethod) {
        this.preprocessMethod = preprocessMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List getUnclassifiedLineItemNumbers() {
        return unclassifiedLineItemNumbers;
    }

    public void setUnclassifiedLineItemNumbers(List unclassifiedLineItemNumbers) {
        this.unclassifiedLineItemNumbers = unclassifiedLineItemNumbers;
    }

    public List<String> getPossibleLineItems() {
        return possibleLineItems;
    }

    public void setPossibleLineItems(List<String> possibleLineItems) {
        this.possibleLineItems = possibleLineItems;
    }
}
