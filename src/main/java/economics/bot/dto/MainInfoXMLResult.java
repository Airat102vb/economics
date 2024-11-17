package economics.bot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MainInfoXMLResult {

  @JacksonXmlProperty(localName = "RegData")
  private RegData regData;

  public RegData getRegData() {
    return regData;
  }

  public void setRegData(RegData regData) {
    this.regData = regData;
  }
}
