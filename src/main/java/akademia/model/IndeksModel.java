package akademia.model;

public class IndeksModel {
  private String name;
  private String CalcDate; //Data wykonania obliczeń indeksu dla wskaźnika SO2
  private Integer Id; //jak wyżej, zakresy indeksu o id od  -1 do 5 lub null jeśli na stacji nie są wykonywane pomiary danego zanieczyszczenia
  private String IndexLevelName; //nazwa kategorii indeksu
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
