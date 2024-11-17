package economics.bot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MainInfoXMLResponse {

  @JacksonXmlProperty(localName = "MainInfoXMLResult")
  private MainInfoXMLResult mainInfoXMLResult;

  public MainInfoXMLResult getMainInfoXMLResult() {
    return mainInfoXMLResult;
  }

  public void setMainInfoXMLResult(MainInfoXMLResult mainInfoXMLResult) {
    this.mainInfoXMLResult = mainInfoXMLResult;
  }
}
