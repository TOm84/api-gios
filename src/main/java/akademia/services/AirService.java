package akademia.services;

import akademia.model.AirModel;
import akademia.model.IndeksModel;
import akademia.model.QualityModel;
import akademia.model.StationModel;
import akademia.utils.ConnectionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Service
public class AirService {
  private final ConnectionUtils connectionUtils;

  public AirService(ConnectionUtils connectionUtils) {
    this.connectionUtils = connectionUtils;
  }

  public AirModel mapAirApiResponse() {
    String url = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/837";
//    HttpResponse response = connectionUtils.getHttpResponse(url);
//    String responseBody = connectionUtils.getBodyFromResponse(response);
    String resp = connectionUtils.getBodyWithHttpResponse(url);
    AirModel airModel;
    try {
      JsonNode jsonNode = new ObjectMapper().readTree(resp);
//      JsonNode jsonNode = new ObjectMapper().readTree(responseBody);
      airModel = new AirModel();
      airModel.setStationId(jsonNode.get(0).get("stationId").asInt());
      airModel.setNo2(jsonNode.get(0).get("param").get("idParam").asInt());
      airModel.setPm10(jsonNode.get(1).get("param").get("idParam").asInt());
      airModel.setSo2(jsonNode.get(2).get("param").get("idParam").asInt());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
      return null;
    }
    return  airModel;
  }

  public TreeMap<String, Integer> stationName() {
    String url = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
    String resp = connectionUtils.getBodyWithHttpResponse(url);

    TreeMap<String, Integer> outputList= new TreeMap<String, Integer>();
    try {
      JsonNode jsonNode = new ObjectMapper().readTree(resp);

      for (Integer i = 0; i <=jsonNode.size()-1 ; i++) {
        outputList.put(jsonNode.get(i).get("stationName").toString(),jsonNode.get(i).get("id").asInt());
      }

    } catch (JsonProcessingException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
      return null;
    }
    outputList.values().stream().sorted();

    return outputList;
  }

  public List<StationModel> allStation() {
    String url = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
    String resp = connectionUtils.getBodyWithHttpResponse(url);

    List<StationModel> outputList= new ArrayList<>();
    try {
      JsonNode jsonNode = new ObjectMapper().readTree(resp);

      for (Integer i = 0; i <=jsonNode.size()-1 ; i++) {

        StationModel stationModel = new StationModel();
        stationModel.setStationId(jsonNode.get(i).get("id").asInt());
        stationModel.setStationName(jsonNode.get(i).get("stationName").toString());
        stationModel.setGegrLat(jsonNode.get(i).get("gegrLat").asDouble());
        stationModel.setGegrLon(jsonNode.get(i).get("gegrLon").asDouble());
        stationModel.setCityId(jsonNode.get(i).get("city").get("id").asInt());
        stationModel.setCityName(jsonNode.get(i).get("city").get("name").toString());
        stationModel.setCommuneName(jsonNode.get(i).get("city").get("commune").get("communeName").toString());
        stationModel.setDistrictName(jsonNode.get(i).get("city").get("commune").get("districtName").toString());
        stationModel.setProvinceName(jsonNode.get(i).get("city").get("commune").get("provinceName").toString());
        stationModel.setAddressStreetStation(jsonNode.get(i).get("addressStreet").toString());
        outputList.add(stationModel);

      }

    } catch (JsonProcessingException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
      return null;
    }

    return outputList;
  }

  public QualityModel qualityModels(Integer idStation) {

    String url = "http://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + idStation;
    String resp = connectionUtils.getBodyWithHttpResponse(url);

    QualityModel qualityModel= new QualityModel();
    try {
      JsonNode jsonNode = new ObjectMapper().readTree(resp);
      qualityModel.setStationId(jsonNode.get("id").asInt());
      qualityModel.setStCalcDate(jsonNode.get("stCalcDate").toString());
      qualityModel.setIdIndexLevelName(jsonNode.get("stIndexLevel").get("id").asInt());
      qualityModel.setStIndexLevelName(jsonNode.get("stIndexLevel").get("indexLevelName").toString());
      qualityModel.setStSourceDataDate(jsonNode.get("stSourceDataDate").toString());
      qualityModel.setStIndexStatus(jsonNode.get("stIndexStatus").booleanValue());
      qualityModel.setStIndexCrParam(jsonNode.get("stIndexCrParam").toString());

      List<IndeksModel> newListModel = new ArrayList<>();


      if (!jsonNode.get("so2IndexLevel").isNull()) {
        IndeksModel indeksModel = new IndeksModel();
        indeksModel.setName("SO2");
        indeksModel.setCalcDate(jsonNode.get("so2CalcDate").toString());
        indeksModel.setId(jsonNode.get("so2IndexLevel").get("id").asInt());
        indeksModel.setIndexLevelName(jsonNode.get("so2IndexLevel").get("indexLevelName").toString());
        indeksModel.setSourceDataDate(jsonNode.get("so2SourceDataDate").toString());
        newListModel.add(indeksModel);
      }

      if (!jsonNode.get("no2IndexLevel").isNull()) {
        IndeksModel indeksModel = new IndeksModel();
        indeksModel.setName("NO2");
        indeksModel.setCalcDate(jsonNode.get("no2CalcDate").toString());
        indeksModel.setId(jsonNode.get("no2IndexLevel").get("id").asInt());
        indeksModel.setIndexLevelName(jsonNode.get("no2IndexLevel").get("indexLevelName").toString());
        indeksModel.setSourceDataDate(jsonNode.get("no2SourceDataDate").toString());
        newListModel.add(indeksModel);
      }

      if (!jsonNode.get("pm10IndexLevel").isNull()) {
        IndeksModel indeksModel = new IndeksModel();
        indeksModel.setName("PM10");
        indeksModel.setCalcDate(jsonNode.get("pm10CalcDate").toString());
        indeksModel.setId(jsonNode.get("pm10IndexLevel").get("id").asInt());
        indeksModel.setIndexLevelName(jsonNode.get("pm10IndexLevel").get("indexLevelName").toString());
        indeksModel.setSourceDataDate(jsonNode.get("pm10SourceDataDate").toString());
        newListModel.add(indeksModel);
      }

      if (!jsonNode.get("pm25IndexLevel").isNull()) {
        IndeksModel indeksModel = new IndeksModel();
        indeksModel.setName("PM25");
        indeksModel.setCalcDate(jsonNode.get("pm25CalcDate").toString());
        indeksModel.setId(jsonNode.get("pm25IndexLevel").get("id").asInt());
        indeksModel.setIndexLevelName(jsonNode.get("pm25IndexLevel").get("indexLevelName").toString());
        indeksModel.setSourceDataDate(jsonNode.get("pm25SourceDataDate").toString());
        newListModel.add(indeksModel);
      }

      if (!jsonNode.get("o3IndexLevel").isNull()) {
        IndeksModel indeksModel = new IndeksModel();
        indeksModel.setName("O3");
        indeksModel.setCalcDate(jsonNode.get("o3CalcDate").toString());
        indeksModel.setId(jsonNode.get("o3IndexLevel").get("id").asInt());
        indeksModel.setIndexLevelName(jsonNode.get("o3IndexLevel").get("indexLevelName").toString());
        indeksModel.setSourceDataDate(jsonNode.get("o3SourceDataDate").toString());
        newListModel.add(indeksModel);
      }

      qualityModel.setIndeksModels(newListModel);
      
//      private String name;
//      private String CalcDate; //Data wykonania obliczeń indeksu dla wskaźnika SO2
//      private Integer Id; //jak wyżej, zakresy indeksu o id od  -1 do 5 lub null jeśli na stacji nie są wykonywane pomiary danego zanieczyszczenia
//      private String IndexLevelName; //nazwa kategorii indeksu
//      private String SourceDataDate;

//      private Integer stationId; // numer id stacji pomiarowej
//      private String stCalcDate; //data wykonania obliczeń indeksu
//      private Integer idIndexLevelName; //wartość indeksu dla stacji wyrażona w postaci liczby -1 – Brak indeksu, 0 – Bardzo dobry, 1 – Dobry, 2 – Umiarkowany, 3 - Dostateczny, 4 – Zły, 5 – Bardzo zły
//      private String stIndexLevelName; // jak wyżej – nazwa kategorii indeksu
//      private String stSourceDataDate; //data danych źródłowych, z których policzono wartość indeksu
//
//      private Boolean stIndexStatus; //Status indeksu ogólnego dla stacji pomiarowej. Może przyjmować wartość „true” (indeks ważny) lub „false” (indeks nieważny/ brak indeksu)
//      private String stIndexCrParam; //
//
//      private List<IndeksModel> indeksModels;

    } catch (JsonProcessingException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
      return null;
    }

    return qualityModel;

  }

}