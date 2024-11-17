package economics.bot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class KeyRate {

  @JacksonXmlProperty(isAttribute = true)
  private String Title;

  @JacksonXmlProperty(isAttribute = true)
  private String Date;

  @JacksonXmlText
  private String value;

  // Геттеры и сеттеры
  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public String getDate() {
    return Date;
  }

  public void setDate(String date) {
    Date = date;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
