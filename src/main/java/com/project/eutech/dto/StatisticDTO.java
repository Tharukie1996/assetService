package com.project.eutech.dto;

import java.util.Map;

/**
 * This DTO carries data required for the dashboard
 */
public class StatisticDTO {

    private int noOfOperationalEquip;

    private int noOfNonOperationalEquip;

    private Map<String, Integer> equipStatMap;

    public StatisticDTO() {
    }

    public StatisticDTO(int noOfOperationalEquip, int noOfNonOperationalEquip, Map<String, Integer> equipStatMap) {
        this.noOfOperationalEquip = noOfOperationalEquip;
        this.noOfNonOperationalEquip = noOfNonOperationalEquip;
        this.equipStatMap = equipStatMap;
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

    public Map<String, Integer> getEquipStatMap() {
        return equipStatMap;
    }

    public void setEquipStatMap(Map<String, Integer> equipStatMap) {
        this.equipStatMap = equipStatMap;
    }
}
