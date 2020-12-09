package com.project.eutech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This DTO is used to map the necessary equipment details receiving from ivava end point
 */

public class EquipmentDTO {

    @JsonProperty("AssetID")
    private String assetId;

    @JsonProperty("OperationalStatus")
    private String operationalStatus;

    @JsonProperty("AssetCategoryID")
    private String assetCategory;

    public EquipmentDTO() {
    }

    public EquipmentDTO(String assetId, String operationalStatus, String assetCategory) {
        this.assetId = assetId;
        this.operationalStatus = operationalStatus;
        this.assetCategory = assetCategory;
    }

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
