package com.project.eutech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class EquipmentDTO {

//    private List<Map<String,String>> equipmentDataList;

    @JsonProperty("AssetID")
    private String assetId;
    @JsonProperty("OperationalStatus")
    private String operationalStatus;
    @JsonProperty("AssetCategoryID")
    private String assetCategory;

    public EquipmentDTO() {
    }

//    public EquipmentDTO(List<Map<String, String>> equipmentDataList) {
//        this.equipmentDataList = equipmentDataList;
//    }
//
    public EquipmentDTO(String assetId, String operationalStatus, String assetCategory) {
        this.assetId = assetId;
        this.operationalStatus = operationalStatus;
        this.assetCategory = assetCategory;
    }

//    public List<Map<String, String>> getEquipmentDataList() {
//        return equipmentDataList;
//    }
//
//    public void setEquipmentDataList(List<Map<String, String>> equipmentDataList) {
//        this.equipmentDataList = equipmentDataList;
//    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }
}
