package com.project.eutech.dto;

public class EquipmentDetailsDTO {

    private String assetType;

    private int assetCount;

    public EquipmentDetailsDTO() {
    }

    public EquipmentDetailsDTO(String assetType, int assetCount) {
        this.assetType = assetType;
        this.assetCount = assetCount;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public int getAssetCount() {
        return assetCount;
    }

    public void setAssetCount(int assetCount) {
        this.assetCount = assetCount;
    }
}
