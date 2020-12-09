package com.project.eutech.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.eutech.dto.EquipmentDTO;
import com.project.eutech.dto.StatisticDTO;
import com.project.eutech.error.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * This is the service layer of the application
 */
@Service
public class EquipmentService {

    @Value("${eutech.apikey}")
    private String apikey;

    private final RestTemplate restTemplate = new RestTemplate();

    private final int max = 100;

    private static final String OPERATIONAL = "Operational";

    public StatisticDTO getTableData() throws JsonProcessingException {

        List<EquipmentDTO> equipmentDTOList = new ArrayList<>();

        for (int i = 0; i < 300; i=i+max) {
            List<EquipmentDTO> returnedDTOList = getEquipmentDetails(i);
            equipmentDTOList.addAll(returnedDTOList);
        }


        HashMap<String, Integer> equipmentCountMap = new HashMap<>();
        StatisticDTO statisticDTO = new StatisticDTO(0, 0);

        equipmentDTOList.forEach(e -> {
            if(equipmentCountMap.containsKey(e.getAssetCategory())) {
                equipmentCountMap.put(e.getAssetCategory(), equipmentCountMap.get(e.getAssetCategory())+1);
            }
            else {
                equipmentCountMap.put(e.getAssetCategory(), 1);
            }
            if (e.getOperationalStatus().equals(OPERATIONAL)) {
                statisticDTO.setNoOfOperationalEquip(statisticDTO.getNoOfOperationalEquip() + 1);
            } else {
                statisticDTO.setNoOfNonOperationalEquip(statisticDTO.getNoOfNonOperationalEquip() + 1);
            }
        });
        statisticDTO.convertMapToList(equipmentCountMap);
        return statisticDTO;
    }

    public List<EquipmentDTO> getEquipmentDetails(int last) throws JsonProcessingException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("http://ivivaanywhere.ivivacloud.com/api/Asset/Asset/All?apikey=" + apikey + "&max=" + max + "&last=" + last,
                        HttpMethod.GET, httpEntity, String.class);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new ApiException("Error occurred when retrieving data with the status code: ", responseEntity.getStatusCode());
        }

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return Arrays.asList(objectMapper.readValue(responseEntity.getBody(), EquipmentDTO[].class).clone());
    }
}
