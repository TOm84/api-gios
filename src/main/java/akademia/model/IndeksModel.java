package akademia.model;

public class IndeksModel {
  private String name;
  private String CalcDate;
  private Integer Id;
  private String IndexLevelName;
  private String SourceDataDate;

  public IndeksModel(String name, String calcDate, Integer id, String indexLevelName, String sourceDataDate) {
    this.name = name;
    CalcDate = calcDate;
    Id = id;
    IndexLevelName = indexLevelName;
    SourceDataDate = sourceDataDate;
  }

  public IndeksModel() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCalcDate() {
    return CalcDate;
  }

  public void setCalcDate(String calcDate) {
    CalcDate = calcDate;
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getIndexLevelName() {
    return IndexLevelName;
  }

  public void setIndexLevelName(String indexLevelName) {
    IndexLevelName = indexLevelName;
  }

  public String getSourceDataDate() {
    return SourceDataDate;
  }

  public void setSourceDataDate(String sourceDataDate) {
    SourceDataDate = sourceDataDate;
  }

  @Override
  public String toString() {
    return "IndeksModel{" +
        "name='" + name + '\'' +
        ", CalcDate='" + CalcDate + '\'' +
        ", Id=" + Id +
        ", IndexLevelName='" + IndexLevelName + '\'' +
        ", SourceDataDate='" + SourceDataDate + '\'' +
        '}';
  }
}
