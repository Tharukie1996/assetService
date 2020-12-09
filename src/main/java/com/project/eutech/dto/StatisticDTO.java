package com.project.eutech.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This DTO carries data required for the dashboard
 */
public class StatisticDTO {

    private int noOfOperationalEquip;

    private int noOfNonOperationalEquip;

    private List<EquipmentDetailsDTO> equipmentStatList;

    private List<String> labelList;

    private List<Integer> dataList;

    public StatisticDTO() {
    }

    public StatisticDTO(int noOfOperationalEquip, int noOfNonOperationalEquip) {
        this.noOfOperationalEquip = noOfOperationalEquip;
        this.noOfNonOperationalEquip = noOfNonOperationalEquip;
    }

    public int getNoOfOperationalEquip() {
        return noOfOperationalEquip;
    }

    public void setNoOfOperationalEquip(int noOfOperationalEquip) {
        this.noOfOperationalEquip = noOfOperationalEquip;
    }

    public int getNoOfNonOperationalEquip() {
        return noOfNonOperationalEquip;
    }

    public void setNoOfNonOperationalEquip(int noOfNonOperationalEquip) {
        this.noOfNonOperationalEquip = noOfNonOperationalEquip;
    }

    public List getEquipmentStatList() {
        return equipmentStatList;
    }

    public void setEquipmentStatList(List<EquipmentDetailsDTO> equipmentStatList) {
        this.equipmentStatList = equipmentStatList;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public List<Integer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Integer> dataList) {
        this.dataList = dataList;
    }

    public void convertMapToList(Map<String, Integer> mapToConvert) {
        ArrayList<EquipmentDetailsDTO> arrayList = new ArrayList<>();
        ArrayList<String> labelArrList = new ArrayList<>();
        ArrayList<Integer> dataArrList = new ArrayList<>();
        mapToConvert.forEach((k,v) -> {
            EquipmentDetailsDTO equipmentDetailsDTO = new EquipmentDetailsDTO(k, v);
            arrayList.add(equipmentDetailsDTO);
            labelArrList.add(k);
            dataArrList.add(v);
        });
        this.setEquipmentStatList(arrayList);
        this.setLabelList(labelArrList);
        this.setDataList(dataArrList);
    }
}
