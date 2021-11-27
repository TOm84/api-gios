package akademia.model;

import java.util.List;

public class QualityModel {
  private Integer stationId; // numer id stacji pomiarowej
  private String stCalcDate; //data wykonania obliczeń indeksu
  private Integer idIndexLevelName; //wartość indeksu dla stacji wyrażona w postaci liczby -1 – Brak indeksu, 0 – Bardzo dobry, 1 – Dobry, 2 – Umiarkowany, 3 - Dostateczny, 4 – Zły, 5 – Bardzo zły
  private String stIndexLevelName; // jak wyżej – nazwa kategorii indeksu
  private String stSourceDataDate; //data danych źródłowych, z których policzono wartość indeksu

  private Boolean stIndexStatus; //Status indeksu ogólnego dla stacji pomiarowej. Może przyjmować wartość „true” (indeks ważny) lub „false” (indeks nieważny/ brak indeksu)
  private String stIndexCrParam; //

  private List<IndeksModel> indeksModels;

  public QualityModel(Integer stationId, String stCalcDate, Integer idIndexLevelName, String stIndexLevelName, String stSourceDataDate, Boolean stIndexStatus, String stIndexCrParam, List<IndeksModel> indeksModels) {
    this.stationId = stationId;
    this.stCalcDate = stCalcDate;
    this.idIndexLevelName = idIndexLevelName;
    this.stIndexLevelName = stIndexLevelName;
    this.stSourceDataDate = stSourceDataDate;
    this.stIndexStatus = stIndexStatus;
    this.stIndexCrParam = stIndexCrParam;
    this.indeksModels = indeksModels;
  }

  public QualityModel() {

  }

  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public String getStCalcDate() {
    return stCalcDate;
  }

  public void setStCalcDate(String stCalcDate) {
    this.stCalcDate = stCalcDate;
  }

  public Integer getIdIndexLevelName() {
    return idIndexLevelName;
  }

  public void setIdIndexLevelName(Integer idIndexLevelName) {
    this.idIndexLevelName = idIndexLevelName;
  }

  public String getStIndexLevelName() {
    return stIndexLevelName;
  }

  public void setStIndexLevelName(String stIndexLevelName) {
    this.stIndexLevelName = stIndexLevelName;
  }

  public String getStSourceDataDate() {
    return stSourceDataDate;
  }

  public void setStSourceDataDate(String stSourceDataDate) {
    this.stSourceDataDate = stSourceDataDate;
  }

  public Boolean getStIndexStatus() {
    return stIndexStatus;
  }

  public void setStIndexStatus(Boolean stIndexStatus) {
    this.stIndexStatus = stIndexStatus;
  }

  public String getStIndexCrParam() {
    return stIndexCrParam;
  }

  public void setStIndexCrParam(String stIndexCrParam) {
    this.stIndexCrParam = stIndexCrParam;
  }

  public List<IndeksModel> getIndeksModels() {
    return indeksModels;
  }

  public void setIndeksModels(List<IndeksModel> indeksModels) {
    this.indeksModels = indeksModels;
  }

  @Override
  public String toString() {
    return "QualityModel{" +
        "stationId=" + stationId +
        ", stCalcDate='" + stCalcDate + '\'' +
        ", idIndexLevelName=" + idIndexLevelName +
        ", stIndexLevelName='" + stIndexLevelName + '\'' +
        ", stSourceDataDate='" + stSourceDataDate + '\'' +
        ", stIndexStatus=" + stIndexStatus +
        ", stIndexCrParam='" + stIndexCrParam + '\'' +
        ", indeksModels=" + indeksModels +
        '}';
  }
}
