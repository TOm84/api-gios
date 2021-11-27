package akademia.model;

public class AirModel {

  private Integer stationId;
  private Integer No2;
  private Integer Pm10;
  private Integer So2;

  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public Integer getNo2() {
    return No2;
  }

  public void setNo2(Integer no2) {
    No2 = no2;
  }

  public Integer getPm10() {
    return Pm10;
  }

  public void setPm10(Integer pm10) {
    Pm10 = pm10;
  }

  public Integer getSo2() {
    return So2;
  }

  public void setSo2(Integer so2) {
    So2 = so2;
  }

  @Override
  public String toString() {
    return "AirModel{" +
        "stationId=" + stationId +
        ", No2=" + No2 +
        ", Pm10=" + Pm10 +
        ", So2=" + So2 +
        '}';
  }

}
