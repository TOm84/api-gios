package akademia.model;

public class StationModel {

  private Integer stationId;
  private String stationName;
  private Double gegrLat;
  private Double gegrLon;


  private Integer cityId;
  private String cityName;

  private String communeName;
  private String districtName;
  private String provinceName;

  private String addressStreetStation;

  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public Double getGegrLat() {
    return gegrLat;
  }

  public void setGegrLat(Double gegrLat) {
    this.gegrLat = gegrLat;
  }

  public Double getGegrLon() {
    return gegrLon;
  }

  public void setGegrLon(Double gegrLon) {
    this.gegrLon = gegrLon;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCommuneName() {
    return communeName;
  }

  public void setCommuneName(String communeName) {
    this.communeName = communeName;
  }

  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getAddressStreetStation() {
    return addressStreetStation;
  }

  public void setAddressStreetStation(String addressStreetStation) {
    this.addressStreetStation = addressStreetStation;
  }

  @Override
  public String toString() {
    return "StationModel{" +
        "stationId=" + stationId +
        ", stationName='" + stationName + '\'' +
        ", gegrLat=" + gegrLat +
        ", gegrLon=" + gegrLon +
        ", cityId=" + cityId +
        ", cityName='" + cityName + '\'' +
        ", communeName='" + communeName + '\'' +
        ", districtName='" + districtName + '\'' +
        ", provinceName='" + provinceName + '\'' +
        ", addressStreetStation='" + addressStreetStation + '\'' +
        '}';
  }
}
