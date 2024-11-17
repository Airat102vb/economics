package economics.bot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Body {

  @JacksonXmlProperty(localName = "MainInfoXMLResponse")
  public MainInfoXMLResponse mainInfoXMLResponse;

  public MainInfoXMLResponse getMainInfoXMLResponse() {
    return mainInfoXMLResponse;
  }

  public void setMainInfoXMLResponse(MainInfoXMLResponse mainInfoXMLResponse) {
    this.mainInfoXMLResponse = mainInfoXMLResponse;
  }
}
