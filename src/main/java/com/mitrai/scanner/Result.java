package com.mitrai.scanner;

import com.mitrai.scanner.receipt.FinalLineItem;
import com.mitrai.scanner.score.ScoreSummary;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nirojans on 1/25/17.
 */
public class Result implements Serializable {

    private String id;
    private String status = "DONE";
    private OCRStats ocrStats;
    private ScoreSummary scoreSummary;
    private List<FinalLineItem> finalOCRLineItemList;
    private List<FinalLineItem> finalManualLineItemList;
    private int batchProcessID;
    private String[] rawData;

    public Result(int batchProcessID) {
        this.batchProcessID = batchProcessID;
    }

    public int getBatchProcessID() {
        return batchProcessID;
    }

    public void setBatchProcessID(int batchProcessID) {
        this.batchProcessID = batchProcessID;
    }

    public ScoreSummary getScoreSummary() {
        return scoreSummary;
    }

    public void setScoreSummary(ScoreSummary scoreSummary) {
        this.scoreSummary = scoreSummary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OCRStats getOcrStats() {
        return ocrStats;
    }

    public void setOcrStats(OCRStats ocrStats) {
        this.ocrStats = ocrStats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FinalLineItem> getFinalOCRLineItemList() {
        return finalOCRLineItemList;
    }

    public void setFinalOCRLineItemList(List<FinalLineItem> finalOCRLineItemList) {
        this.finalOCRLineItemList = finalOCRLineItemList;
    }

    public List<FinalLineItem> getFinalManualLineItemList() {
        return finalManualLineItemList;
    }

    public void setFinalManualLineItemList(List<FinalLineItem> finalManualLineItemList) {
        this.finalManualLineItemList = finalManualLineItemList;
    }

    public String[] getRawData() {
        return rawData;
    }

    public void setRawData(String[] rawData) {
        this.rawData = rawData;
    }
}

